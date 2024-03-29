package buu.informatics.s59160141.parkingplace

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160141.parkingplace.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val slot1: CarData = CarData(0,"","","")
    private val slot2: CarData = CarData(1,"","","")
    private val slot3: CarData = CarData(2,"","","")
    private val slots = arrayOf(slot1,slot2,slot3)
    private var slotIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        hide()

        binding.apply {
            this.slots = this@MainActivity.slots
            slot_1.setOnClickListener{view ->
                click(view)
            }
            slot_2.setOnClickListener{view ->
                click(view)
            }
            slot_3.setOnClickListener{view ->
                click(view)
            }
        }
    }

    private fun getSlot(view:View):Int {
        when(view.id) {
            R.id.slot_1 -> return 0
            R.id.slot_2 -> return 1
            R.id.slot_3 -> return 2
        }
        return -1
    }

    private fun setButtonColor(int: Int){
        when(int){
            0 -> {slot_1.setBackgroundResource(R.color.slotSelect)
                slot_2.setBackgroundResource(R.color.slot)
                slot_3.setBackgroundResource(R.color.slot)
            }
            1 -> {slot_2.setBackgroundResource(R.color.slotSelect)
                slot_1.setBackgroundResource(R.color.slot)
                slot_3.setBackgroundResource(R.color.slot)
            }
            2 -> {slot_3.setBackgroundResource(R.color.slotSelect)
                slot_1.setBackgroundResource(R.color.slot)
                slot_2.setBackgroundResource(R.color.slot)
            }
        }
    }

    private fun click(view: View) {
        show()
        setButtonColor(getSlot(view))
        binding.apply {
            slotIndex = getSlot(view)
            this.carData = slots?.get(slotIndex)
            invalidateAll()

            update_button.setOnClickListener{view ->
                update(slotIndex)
            }
            delete_button.setOnClickListener{view ->
                delete(slotIndex)
            }
        }
    }

    private fun update(int: Int){
        when(int) {
            0 -> { if(slot_1.text != ""){
                    slot_1.text = licensePlate.text.toString()
                }else{
                    slot_1.text = "Empty"
                }
            }
            1 -> { if(slot_2.text != ""){
                    slot_2.text = licensePlate.text.toString()
                }else{
                    slot_2.text = "Empty"
                }
            }
            2 -> { if(slot_3.text != ""){
                    slot_3.text = licensePlate.text.toString()
                }else{
                    slot_3.text = "Empty"
                }
            }
        }
    }

    private fun delete(int: Int){
        binding.apply {
            when(int) {
                0 -> {slot_1.text = "Empty"
                    licensePlate.text.clear()
                    carBrand.text.clear()
                    name.text.clear()
                }
                1 -> {slot_2.text = "Empty"
                    licensePlate.text.clear()
                    carBrand.text.clear()
                    name.text.clear()
                }
                2 -> {slot_3.text = "Empty"
                    licensePlate.text.clear()
                    carBrand.text.clear()
                    name.text.clear()
                }
            }
            invalidateAll()
        }
    }

    private fun hide(){
        binding.apply{
            licensePlate.visibility = View.GONE
            carBrand.visibility = View.GONE
            name.visibility = View.GONE
            update_button.visibility = View.GONE
            delete_button.visibility = View.GONE
        }
    }

    private fun show(){
        binding.apply{
            licensePlate.visibility = View.VISIBLE
            carBrand.visibility = View.VISIBLE
            name.visibility = View.VISIBLE
            update_button.visibility = View.VISIBLE
            delete_button.visibility = View.VISIBLE
        }
    }

}
