package com.dhh.audition.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dhh.audition.R
import com.dhh.audition.bean.TestBean2

class TestAdapter(list: List<TestBean2>): BaseQuickAdapter<TestBean2, BaseViewHolder>(R.layout.item_test1, list) {
    override fun convert(helper: BaseViewHolder?, item: TestBean2?) {
        helper?.setText(R.id.tv_name, item?.name)
    }
}