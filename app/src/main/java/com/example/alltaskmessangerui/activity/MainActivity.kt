package com.example.alltaskmessangerui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.alltaskmessangerui.R
import com.example.alltaskmessangerui.fragment.ChatsFragment
import com.example.alltaskmessangerui.fragment.PeopleFragment
import com.example.alltaskmessangerui.model.Message
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        val items = prepareMessageList()
        val chatsFragment = ChatsFragment().newInstance(items)
        val peopleFragment = PeopleFragment().newInstance(items)

        setCurrentFragment(chatsFragment)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.chats -> setCurrentFragment(chatsFragment)
                R.id.people -> setCurrentFragment(peopleFragment)
            }
            true
        }

        var badge = bottomNavigationView.getOrCreateBadge(R.id.chats)
        badge.isVisible = true
        badge.number = 99

    }


    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
    }

    private fun prepareMessageList(): ArrayList<Message> {
        val items: ArrayList<Message> = ArrayList()

        items.add(Message(0, "", "", false))
        items.add(
            Message(
                R.drawable.azamat,
                "Azamat Zarpullayev",
                "Mana men ko`chani boshiga yetay dedim",
                false
            )
        )
        items.add(
            Message(
                R.drawable.shahriyor,
                "Shaxriyor Mirzamurodov",
                "Abbos has just sent a voice message. Friday",
                true
            )
        )
        items.add(
            Message(
                R.drawable.jonibek,
                "Jonibek Tinchlikov",
                "Assalomu alaykum do`stim qandesan",
                false
            )
        )
        items.add(Message(R.drawable.elyor, "Elyor Mamayev", "Abbos Toshkentdamisan", true))
        items.add(
            Message(
                R.drawable.ulugbek,
                "Ulug`bek Maxanov",
                "Abbos has just sent a voice message. Friday",
                true
            )
        )
        items.add(Message(R.drawable.javohir, "Javohir Nurbekov", "Nima gappppppp", true))
        items.add(
            Message(
                R.drawable.qilichbek,
                "Qilichbek Pardaboyev",
                "Qande do`stim ishlaring zorma",
                false
            )
        )
        items.add(
            Message(
                R.drawable.azamat,
                "Azamat Zarpullayev",
                "Mana men ko`chani boshiga yetay dedim",
                false
            )
        )
        items.add(
            Message(
                R.drawable.shahriyor,
                "Shaxriyor Mirzamurodov",
                "Abbos has just sent a voice message. Friday",
                true
            )
        )
        items.add(
            Message(
                R.drawable.jonibek,
                "Jonibek Tinchlikov",
                "Assalomu alaykum do`stim qandesan",
                false
            )
        )
        items.add(Message(R.drawable.elyor, "Elyor Mamayev", "Abbos Toshkentdamisan", true))
        items.add(
            Message(
                R.drawable.ulugbek,
                "Ulug`bek Maxanov",
                "Abbos has just sent a voice message. Friday",
                true
            )
        )
        items.add(Message(R.drawable.javohir, "Javohir Nurbekov", "Nima gappppppp", true))
        items.add(
            Message(
                R.drawable.qilichbek,
                "Qilichbek Pardaboyev",
                "Qande do`stim ishlaring zorma",
                false
            )
        )
        items.add(
            Message(
                R.drawable.azamat,
                "Azamat Zarpullayev",
                "Mana men ko`chani boshiga yetay dedim",
                false
            )
        )

        return items
    }

}