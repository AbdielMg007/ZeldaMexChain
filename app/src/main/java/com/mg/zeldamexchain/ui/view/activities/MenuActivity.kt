package com.mg.zeldamexchain.ui.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.mg.zeldamexchain.R
import com.mg.zeldamexchain.databinding.ActivityMenuBinding
import com.mg.zeldamexchain.ui.view.fragments.MenuFragment
import com.mg.zeldamexchain.ui.view.fragments.NftFragment
import com.mg.zeldamexchain.ui.view.fragments.SettingsFragment

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MenuFragment())
        setup()
    }

    private fun setup() {

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeNav -> replaceFragment(MenuFragment())
                R.id.nftNav-> availableAccount(NftFragment())
                R.id.settingsNav -> availableAccount(SettingsFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentMager = supportFragmentManager
        val fragmentTrasaction = fragmentMager.beginTransaction()
        fragmentTrasaction.replace(R.id.fragmentNav, fragment)
        fragmentTrasaction.commit()
    }

    private fun availableAccount(fragment: Fragment){
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser == null) {
            val returnLogin = Intent(this, LoginActivity::class.java)
            startActivity(returnLogin)
            finish()
            Toast.makeText(applicationContext,"Inicia sesion para acceder a este apartado", Toast.LENGTH_SHORT).show()
        }
        replaceFragment(fragment)
    }
}