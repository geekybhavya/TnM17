package com.example.sachinaggarwal.tnm17.ParallaxViewPager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.widget.DrawerLayout;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.sachinaggarwal.tnm17.Fragments.Schedule;
import com.example.sachinaggarwal.tnm17.R;

import java.util.ArrayList;

//<<<<<<< Updated upstream
//=======
////<<<<<<< HEAD
////import android.content.Intent;
////import android.graphics.Color;
////import android.graphics.drawable.ColorDrawable;
////import android.os.Build;
////import android.os.Bundle;
//import android.support.annotation.RequiresApi;
////import android.support.v4.app.Fragment;
////import android.util.TypedValue;
////=======
//>>>>>>> Stashed changes

//<<<<<<< Updated upstream
//=======
////>>>>>>> parallax package
////<<<<<<< HEAD
////import android.view.animation.BounceInterpolator;
////import android.widget.AbsListView;
////import android.widget.AbsListView.OnScrollListener;
////import android.widget.ArrayAdapter;
////import android.widget.ListAdapter;
////import android.widget.ListView;
////import android.widget.SimpleAdapter;
////import android.widget.TextView;
////=======
////>>>>>>> parallax package
////<<<<<<< HEAD
////import java.util.HashMap;
////=======
////>>>>>>> parallax package
//>>>>>>> Stashed changes

public class SampleListFragment extends ScrollTabHolderFragment {

    private static final String ARG_POSITION = "position";

//<<<<<<< Updated upstream
//
//       private ListView mListView;
//=======
//<<<<<<< HEAD
private ListView mListView;
//    private SwipeMenuListView mList;
//        private ArrayList<String> mListItems;
//
//    private int mPosition;
//
//    String[] events_1;
//    int[] images;
//    String[] timing;
//    String[] intents;
//    TextView eventName, act_name;
//
//=======
    //    private ListView mListView;
  private SwipeMenuListView mList;
    private ArrayList<String> mListItems;

    private int mPosition;
//
//<<<<<<< Updated upstream
//
//=======
////>>>>>>> parallax package
//>>>>>>> Stashed changes
    public static Fragment newInstance(int position) {
        SampleListFragment f = new SampleListFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments().getInt(ARG_POSITION);
//<<<<<<< Updated upstream
//
//
//=======
////
////<<<<<<< HEAD
//>>>>>>> Stashed changes
        mListItems = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            mListItems.add(i + ". item - currnet page: " + (mPosition + 1));
        }
//<<<<<<< Updated upstream
//
////        mListItems = new ArrayList<String>();
//=======
////=======
//////        mListItems = new ArrayList<String>();
//>>>>>>> Stashed changes
////
////        for (int i = 1; i <= 100; i++) {
////            mListItems.add(i + ". item - currnet page: " + (mPosition + 1));
////        }
//<<<<<<< Updated upstream
//=======
////>>>>>>> parallax package
//>>>>>>> Stashed changes
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.fragment_list, null);

        mListView = (ListView) v.findViewById(R.id.listView);

        View v1 = inflater.inflate(R.layout.schedule_list, null);
    mList = (SwipeMenuListView) v1.findViewById(R.id.schedule_categories_listView);


        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(getContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xf4, 0x43, 0x36)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(getContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0x28,
                        0x28, 0x28)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_settings);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        View placeHolderView = inflater.inflate(R.layout.view_header_placeholder, mListView, false);
        placeHolderView.setBackgroundColor(0xFFFFFFFF);
        mListView.addHeaderView(placeHolderView);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListView.setOnScrollListener(new OnScroll());
        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, android.R.id.text1, mListItems));
//
//<<<<<<< Updated upstream
//
//        if (Schedule.NEEDS_PROXY) {//in my moto phone(android 2.1),setOnScrollListener do not work well
//=======
//<<<<<<< HEAD
//        if(Schedule.NEEDS_PROXY){//in my moto phone(android 2.1),setOnScrollListener do not work well
//=======
        if (Schedule.NEEDS_PROXY) {//in my moto phone(android 2.1),setOnScrollListener do not work well
//>>>>>>> parallax package
//>>>>>>> Stashed changes
            mListView.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (mScrollTabHolder != null)
                        mScrollTabHolder.onScroll(mListView, 0, 0, 0, mPosition);
                    return false;
                }
            });
        }
    }

    @Override
    public void adjustScroll(int scrollHeight) {
        if (scrollHeight == 0 && mListView.getFirstVisiblePosition() >= 1) {
            return;
        }

        mListView.setSelectionFromTop(1, scrollHeight);

    }


//<<<<<<< Updated upstream
//    public class OnScroll implements OnScrollListener {
//=======
    class OnScroll implements OnScrollListener {
//>>>>>>> Stashed changes

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem,
                             int visibleItemCount, int totalItemCount) {
            if (mScrollTabHolder != null)
                mScrollTabHolder.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount, mPosition);
        }

    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount, int pagePosition) {
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.schedule_list, null);
//
//        mList = (SwipeMenuListView) v.findViewById(R.id.schedule_categories_listView);
//
//        // step 1. create a MenuCreator
//        SwipeMenuCreator creator = new SwipeMenuCreator() {
//
//            @Override
//            public void create(SwipeMenu menu) {
//                // create "open" item
//                SwipeMenuItem openItem = new SwipeMenuItem(getContext());
//                // set item background
//                openItem.setBackground(new ColorDrawable(Color.rgb(0xf4, 0x43, 0x36)));
//                // set item width
//                openItem.setWidth(dp2px(90));
//                // set item title
//                openItem.setTitle("Open");
//                // set item title fontsize
//                openItem.setTitleSize(18);
//                // set item title font color
//                openItem.setTitleColor(Color.WHITE);
//                // add to menu
//                menu.addMenuItem(openItem);
//
//                // create "delete" item
//                SwipeMenuItem deleteItem = new SwipeMenuItem(getContext());
//                // set item background
//                deleteItem.setBackground(new ColorDrawable(Color.rgb(0x28,
//                        0x28, 0x28)));
//                // set item width
//                deleteItem.setWidth(dp2px(90));
//                // set a icon
//                deleteItem.setIcon(R.drawable.ic_settings);
//                // add to menu
//                menu.addMenuItem(deleteItem);
//            }
//        };
//
////        View placeHolderView = inflater.inflate(R.layout.view_header_placeholder, mListView, false);
////        placeHolderView.setBackgroundColor(0xFFFFFFFF);
////        mListView.addHeaderView(placeHolderView);
//
//        // set creator
//        mList.setMenuCreator(creator);
//        mList.setOpenInterpolator(new BounceInterpolator());
//        mList.setCloseInterpolator(new BounceInterpolator());
//
//
//        //Add events in this array
//        events_1 = new String[]{"Alkhwarizm", "Blind War", "C Fresh", "C Hunt", "C Master", "Ex-Machina", "Humble Fool Cup", "Infinitum", "Three Muskeeters"};
//
//        images = new int[]{R.drawable.alkhwarizm, R.drawable.blindwar, R.drawable.cfresh, R.drawable.chunt, R.drawable.exmachina, R.drawable.humblefool};
//
//        timing = new String[]{"6:00 PM, CC3", "6:00 PM, CC3", "2:00 PM - 6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3", "6:00 PM, CC3"};
//
//        intents = new String[]{"ALK", "BLI", "CFR", "CHU", "CMA", "EXM", "HUM", "INF", "THR"};
//
//        initList(events_1, images, timing, intents);
//
//        return v;
//    }
//
//    public void initList(String[] eventsArray, int[] imagesList, String[] timingList, String[] intentsList) {
//        if (eventsArray.length != 0) {
//
//            ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();
//
//            for (int i = 0; i < eventsArray.length; i++) {
//                HashMap<String, String> candy = new HashMap<String, String>();
//                candy.put("event", eventsArray[i]);
//                candy.put("image", Integer.toString(imagesList[i]));
//                candy.put("time", timingList[i]);
//                candy.put("intent", "com.app.aparoksha.apro16." + intentsList[i].trim());
//                eventList.add(candy);
//            }
//
//            ListAdapter adapter = new SimpleAdapter(
//                    getContext(),
//                    eventList,
//                    R.layout.schedule_list_item,
//                    new String[]{"event", "image", "time", "intent"},
//                    new int[]{R.id.event_name, R.id.eventImg, R.id.eventTime, R.id.intent}) {
//                @Override
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    View view = super.getView(position, convertView, parent);
//                    TextView item_name = (TextView) view.findViewById(R.id.event_name);
//                    return view;
//                }
//            };
//
//            mList.setAdapter(adapter);
//        }
//
//        mList.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
//                switch (index) {
//                    case 0:
//                        // open
//
//                        String intentToOpen = "com.app.aparoksha.apro16." + intents[position];
//
//                        Intent i = new Intent(intentToOpen);
//                        i.putExtra("INTENT", intentToOpen);
//                        startActivity(i);
//
//                        break;
//                    case 1:
//                        Intent it = new Intent("com.app.aparoksha.apro16.SN");
//                        it.putExtra("event", events_1[position]);
//                        it.putExtra("address", "com.app.aparoksha.apro16." + intents[position]);
//                        startActivity(it);
//                        break;
//                }
//                return false;
//            }
//        });
//
//    }
//
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
////        mListView.setOnScrollListener(new OnScroll());
////        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, android.R.id.text1, mListItems));
////
////        if (Schedule.NEEDS_PROXY) {//in my moto phone(android 2.1),setOnScrollListener do not work well
////            mListView.setOnTouchListener(new OnTouchListener() {
////                @Override
////                public boolean onTouch(View v, MotionEvent event) {
////                    if (mScrollTabHolder != null)
////                        mScrollTabHolder.onScroll(mListView, 0, 0, 0, mPosition);
////                    return false;
////                }
////            });
////        }
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void adjustScroll(int scrollHeight) {
//        if (scrollHeight == 0 && mList.getFirstVisiblePosition() >= 1) {
//            return;
//        }
//
//        mList.setSelectionFromTop(1, scrollHeight);
//
//    }
//
//    public class OnScroll implements OnScrollListener {
//
//        @Override
//        public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//        }
//
//        @Override
//        public void onScroll(AbsListView view, int firstVisibleItem,
//                             int visibleItemCount, int totalItemCount) {
//            if (mScrollTabHolder != null)
//                mScrollTabHolder.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount, mPosition);
//        }
//
//    }
//
//
//    @Override
//    public void onScroll(AbsListView view, int firstVisibleItem,
//                         int visibleItemCount, int totalItemCount, int pagePosition) {
//    }


}