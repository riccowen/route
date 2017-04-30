package com.qg.route.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.WalkPath;
import com.qg.route.utils.Constant;

/**
 * Created by Ricco on 2017/4/13.
 * 关于路线
 */

public class Trace implements Parcelable{
    private LatLonPoint mStartPoint;
    private LatLonPoint mEndPoint;
    private int selectedRouteType;
    private BusPath mBusPath;
    private RidePath mRidePath;
    private DrivePath mDrivePath;
    private WalkPath mWalkPath;

    public Trace(LatLonPoint mStartPoint, LatLonPoint mEndPoint, int selectedRouteType, Path path) {
        this.mStartPoint = mStartPoint;
        this.mEndPoint = mEndPoint;
        this.selectedRouteType = selectedRouteType;
        switch (selectedRouteType) {
            case Constant.ROUTE_TYPE_WALK:
                mWalkPath = (WalkPath) path;
                break;
            case Constant.ROUTE_TYPE_BUS:
                mBusPath = (BusPath) path;
                break;
            case Constant.ROUTE_TYPE_DRIVE:
                mDrivePath = (DrivePath) path;
                break;
            case Constant.ROUTE_TYPE_RIDE:
                mRidePath = (RidePath) path;
        }
    }

    public LatLonPoint getmStartPoint() {
        return mStartPoint;
    }

    public LatLonPoint getmEndPoint() {
        return mEndPoint;
    }

    public int getSelectedRouteType() {
        return selectedRouteType;
    }

    public BusPath getmBusPath() {
        return mBusPath;
    }

    public RidePath getmRidePath() {
        return mRidePath;
    }

    public DrivePath getmDrivePath() {
        return mDrivePath;
    }

    public WalkPath getmWalkPath() {
        return mWalkPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(selectedRouteType);
        dest.writeParcelable(mStartPoint, flags);
        dest.writeParcelable(mEndPoint, flags);
        dest.writeParcelable(mWalkPath, flags);
        dest.writeParcelable(mBusPath, flags);
        dest.writeParcelable(mRidePath, flags);
        dest.writeParcelable(mDrivePath, flags);
    }

    public static final Creator<Trace> CREATOR = new Creator<Trace>() {
        @Override
        public Trace createFromParcel(Parcel source) {
            return new Trace(source);
        }

        @Override
        public Trace[] newArray(int size) {
            return new Trace[size];
        }
    };

    protected Trace(Parcel in) {
        selectedRouteType = in.readInt();
        mStartPoint = in.readParcelable(LatLonPoint.class.getClassLoader());
        mEndPoint = in.readParcelable(LatLonPoint.class.getClassLoader());
        mWalkPath = in.readParcelable(WalkPath.class.getClassLoader());
        mBusPath = in.readParcelable(BusPath.class.getClassLoader());
        mRidePath = in.readParcelable(RidePath.class.getClassLoader());
        mDrivePath = in.readParcelable(DrivePath.class.getClassLoader());
    }
}
