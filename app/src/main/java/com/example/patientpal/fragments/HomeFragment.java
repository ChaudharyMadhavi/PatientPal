package com.example.patientpal.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.patientpal.R;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator3;

public class HomeFragment extends Fragment {

    private ViewPager2 mviewpager2;
    private CircleIndicator3 mCircleIndecator3;
    private List<photo> mListPhoto;
    private Handler mHandler = new Handler();
    private Runnable mRunnable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mviewpager2 = view.findViewById(R.id.view_pager);
        mCircleIndecator3 = view.findViewById(R.id.circle_indicator_3);

        mListPhoto = getListPhoto();
        PhotoViewPager2Adapter adapter = new PhotoViewPager2Adapter(mListPhoto);
        mviewpager2.setAdapter(adapter);
        mCircleIndecator3.setViewPager(mviewpager2);

        autoSlideImages(); // Start auto-sliding

        return view;
    }

    private List<photo> getListPhoto() {
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.image1));  // Ensure these images exist in your drawable folder
        list.add(new photo(R.drawable.image2));
        list.add(new photo(R.drawable.image3));
        return list;
    }

    private void autoSlideImages() {
        mRunnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = mviewpager2.getCurrentItem();
                int totalItems = mListPhoto.size();

                if (currentItem < totalItems - 1) {
                    mviewpager2.setCurrentItem(currentItem + 1);
                } else {
                    mviewpager2.setCurrentItem(0); // Loop back to the first item
                }

                // Keep running this every 2 seconds
                mHandler.postDelayed(this, 2000);
            }
        };

        // Start the auto-slide after 2 seconds
        mHandler.postDelayed(mRunnable, 2000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Remove the runnable when the fragment view is destroyed to prevent memory leaks
        mHandler.removeCallbacks(mRunnable);
    }
}
