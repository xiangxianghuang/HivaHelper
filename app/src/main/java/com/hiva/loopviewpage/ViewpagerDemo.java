//package com.hiva.loopviewpage;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v4.view.ViewPager.OnPageChangeListener;
//import android.util.SparseArray;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.github.promeg.pinyinhelper.Pinyin;
//import com.yongyida.robot.hivahelper.R;
//import com.yongyida.robot.utils.LogHelper;
//
//import java.util.ArrayList;
//
//public class ViewpagerDemo extends Activity implements OnPageChangeListener {
//
//    private static final String TAG = ViewpagerDemo.class.getSimpleName() ;
//
//    private ViewPager viewPager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.viewpager);
//
//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//
////        initData();
//        viewPager.setAdapter(new ViewPagerAdapter());
//        viewPager.addOnPageChangeListener(ViewpagerDemo.this);
//        // 设置viewpager在第二个视图显示
//        viewPager.setCurrentItem(1);
//
//        String s = Pinyin.toPinyin("解元","'");
//        LogHelper.i(TAG, LogHelper.__TAG__() + "s : " + s);
//        s = Pinyin.toPinyin("释","'");
//        LogHelper.i(TAG, LogHelper.__TAG__() + "s : " + s);
//        s = Pinyin.toPinyin("*(带我)?(到|去)","");
//        LogHelper.i(TAG, LogHelper.__TAG__() + "s : " + s);
//
//    }
//
//
//
//
//
//
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        LogHelper.i(TAG, LogHelper.__TAG__() + ",position : " + position + ",positionOffset : " + positionOffset + ",positionOffsetPixels : " + positionOffsetPixels);
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//
//        LogHelper.i(TAG, LogHelper.__TAG__() + ", position : " + position);
//
//        this.position = position ;
//
//
//    }
//    private int position ;
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//        LogHelper.i(TAG, LogHelper.__TAG__() + ",state : " + state );
//
//        if(state == ViewPager.SCROLL_STATE_IDLE){
//
//            final int firstIndex = 0 ;
//            final int lastIndex = views.size() - 1 ;
//
//            if(firstIndex == position){
//
//                viewPager.setCurrentItem(lastIndex - 1 , false);
//
//            }else if(lastIndex == position){
//
//                viewPager.setCurrentItem(1 , false);
//            }
//        }
//
//
//    }
//
//
//
//    private int[] bgColors = { 0xFFFF0000, 0xFFFF7F00, 0xFFFFFF00, 0xFF00FF00, 0xFF00FFFF, 0xFF0000FF, 0xFF8B00FF };
//    private SparseArray<View> usedViews = new SparseArray<>() ;
//    private SparseArray<View> unUsedViews = new SparseArray<>() ;
//    class ViewPagerAdapter extends PagerAdapter {
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//
//            View view = views.get(position);
//            container.removeView(view);
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int i) {
//
//            View view = unUsedViews.get(i) ;
//            if(view == null)
//
//
//            container.addView(views.get(i));
//
//            return views.get(i);
//        }
//
//        @Override
//        public int getCount() {
//
//            int size = bgColors.length ;
//            if(size > 1){
//
//                return size + 2 ;
//
//            }else{
//
//                return size ;
//            }
//
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object o) {
//            return view == o;
//        }
//    }
//}
