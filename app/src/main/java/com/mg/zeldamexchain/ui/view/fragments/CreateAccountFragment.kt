package com.mg.zeldamexchain.ui.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import com.google.firebase.auth.FirebaseAuth
import com.mg.zeldamexchain.R
import com.mg.zeldamexchain.databinding.FragmentCreateAccountBinding
import com.mg.zeldamexchain.ui.helpers.DialogUtils
import com.mg.zeldamexchain.ui.helpers.FragmentBack.backPress
import com.mg.zeldamexchain.ui.view.activities.MenuActivity

class CreateAccountFragment : Fragment(R.layout.fragment_create_account) {
    private lateinit var binding: FragmentCreateAccountBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateAccountBinding.bind(view)
        setup()
    }

    private fun setup() {
        //Not show progressbar when start the fragment
        binding.progressBarCreateAccount.isInvisible = true
        //With this function if press the button back return to EntryFragment
        backPress(this)
        binding.entryCreateBtn.setOnClickListener {
            //If push the button entryCreateBtn go to entryBtnAction and show the progressBar
            binding.progressBarCreateAccount.isInvisible = false
            entryBtnAction()
        }
    }

    private fun entryBtnAction() {
        if (binding.emailCreateInput.text.isEmpty() && binding.passwordCreateInput.text.isEmpty()) {
            //Show warning if is empty emailCreateInput or passwordCreateInput
            binding.progressBarCreateAccount.isInvisible = true
            Toast.makeText(
                context,
                resources.getString(R.string.text_empty_alert),
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        //If is not empty emailInput and passwordInput continue with firebase createUser
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
            binding.emailCreateInput.text.toString(),
            binding.passwordCreateInput.text.toString()
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                //If all is correct you go to MenuActivity with your new account
                val nextScreen = Intent(context, MenuActivity::class.java)
                startActivity(nextScreen)
                binding.progressBarCreateAccount.isInvisible = true
                return@addOnCompleteListener
            }
            //Show Alert Dialog if you have a mistake about your access credentials
            binding.progressBarCreateAccount.isInvisible = true
            DialogUtils.showAlertDialog(
                context,
                resources.getString(R.string.error),
                resources.getString(R.string.error_create_account),
                resources.getString(R.string.accept)
            )
        }
    }
}