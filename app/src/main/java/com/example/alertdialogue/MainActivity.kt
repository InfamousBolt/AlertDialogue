package com.example.alertdialogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addContact=AlertDialog.Builder(this)
                .setTitle("Add Contact")
                .setMessage("Do you want to add Mr.X as a contact?")
                .setIcon(R.drawable.ic_add_contact_foreground)
                .setPositiveButton("Yes"){_, _ ->
                    Toast.makeText(this,"You added Mr.X",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No"){_, _ ->
                    Toast.makeText(this,"You didn't added Mr.X",Toast.LENGTH_SHORT).show()
                }.create()
        dialogue1.setOnClickListener {
            addContact.show()
        }
        val options = arrayOf("First","Second","Third","Fourth")
        val selectOneItemAlertDialog=AlertDialog.Builder(this)
            .setTitle("Choose one item")
            .setSingleChoiceItems(options,0){dialogInterface, i ->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes"){_, _ ->
                Toast.makeText(this,"You accepted the change.",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_, _ ->
                Toast.makeText(this,"You declined the change.",Toast.LENGTH_SHORT).show()
            }.create()
        val selectMultipleItemAlertDialog=AlertDialog.Builder(this)
            .setTitle("Choose multiple items")
            .setMessage("Select items from the list")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false,false)){dialogInterface, i, isChecked ->
                if(isChecked){
                    Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"You didn't click on ${options[i]}",Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Yes"){_, _ ->
                Toast.makeText(this,"You accepted the change.",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_, _ ->
                Toast.makeText(this,"You declined the change.",Toast.LENGTH_SHORT).show()
            }.create()
        dialogue2.setOnClickListener {
            selectOneItemAlertDialog.show()
        }
        dialogue3.setOnClickListener {
            selectMultipleItemAlertDialog.show()
        }

    }
}