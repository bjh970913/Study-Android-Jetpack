package works.bjh.study.jetpack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import works.bjh.study.jetpack.databinding.LayoutUserBinding
import works.bjh.study.jetpack.model.User

class MainActivity : AppCompatActivity(), OnMainActivityAddClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding: LayoutUserBinding = DataBindingUtil.setContentView(this, R.layout.layout_user)

        val binding = LayoutUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = User("Ji Hun", "Baek", 1)
        binding.user = user

        binding.userClickHandler = OtherOnAddHandler()
        binding.mainActivity = this
    }

    private lateinit var user: User

    override fun onUserCLick(view: View) {
        Log.i("onCLick Event", "Main Activity got event")
    }
}

class OtherOnAddHandler : OnMainActivityAddClick {
    override fun onUserCLick(view: View) {
        Log.i("onCLick Event", "Other implementation got event")
    }
}

interface OnMainActivityAddClick {
    fun onUserCLick(view: View)
}
