package com.example.myapplication_madlab03

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Load default fragment (Habits)
        loadFragment(HabitsFragment())

        // Bottom Nav Icons
        val navHabit = findViewById<ImageView>(R.id.nav_habit)
        val navMood = findViewById<ImageView>(R.id.nav_mood)
        val navHydration = findViewById<ImageView>(R.id.nav_hydration)
        val navSettings = findViewById<ImageView>(R.id.nav_settings)

        // Click Listeners
        navHabit.setOnClickListener {
            loadFragment(HabitsFragment())
        }
        navMood.setOnClickListener {
            loadFragment(MoodFragment())
        }
        navHydration.setOnClickListener {
            loadFragment(HydrationFragment())
        }
        navSettings.setOnClickListener {
            loadFragment(SettingsFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
