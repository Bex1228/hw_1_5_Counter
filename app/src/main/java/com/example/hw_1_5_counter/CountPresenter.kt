package com.example.hw_1_5_counter

class CountPresenter(private val counterView: CounterView) {

    private var model = Injector.getModel()

    fun increment() {
        model.increment()
        counterView.showChangeCount(model.count)
        val count = model.count
        counterView.showChangeCount(count)

        if (count == 10) {
            counterView.showToast()
        } else if (count == 15) {
            counterView.changeTextColor()
        }
    }

    fun decrement() {
        model.decrement()
        counterView.showChangeCount(model.count)
    }
}