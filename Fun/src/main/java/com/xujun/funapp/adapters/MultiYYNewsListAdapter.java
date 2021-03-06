package com.xujun.funapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.xujun.funapp.R;
import com.xujun.funapp.beans.YYNews.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity;
import com.xujun.funapp.common.APP;
import com.xujun.funapp.common.Constants;
import com.xujun.funapp.common.recyclerView.BaseRecyclerHolder;
import com.xujun.funapp.common.recyclerView.MultiItemAdapter;
import com.xujun.funapp.common.recyclerView.MultiItemTypeSupport;
import com.xujun.funapp.common.util.SPUtils;
import com.xujun.funapp.image.ImageRequestManager;
import com.xujun.mylibrary.utils.ListUtils;
import com.xujun.mylibrary.utils.StringUtils;
import com.xujun.mylibrary.utils.UriUtils;

import java.util.List;

/**
 * @ explain:
 * @ author：xujun on 2016/10/28 19:26
 * @ email：gdutxiaoxu@163.com
 */
public class MultiYYNewsListAdapter extends MultiItemAdapter<ContentlistEntity> {

    Object pictureTag;
    public static int TYPE_ONE = 100;
    public static int TYPE_TWO = 101;

    public MultiYYNewsListAdapter(Context context, List<ContentlistEntity> datas,
                                  MultiItemTypeSupport<ContentlistEntity> multiItemTypeSupport) {
        super(context, datas, multiItemTypeSupport);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, ContentlistEntity item, int position) {
        if(holder.getItemViewType()==TYPE_ONE){
            setDataOne(holder, item);
        }else{
            setDataTwo(holder,item);
        }

    }

    private void setDataTwo(BaseRecyclerHolder holder, ContentlistEntity item) {
        TextView tvTime = holder.getView(R.id.tv_time);
        TextView tvTitle = holder.getView(R.id.tv_title);
        TextView tvSource = holder.getView(R.id.tv_source);
        TextView tvDes = holder.getView(R.id.tv_des);
        String title = StringUtils.getStr(item.title);
        List<ContentlistEntity.ImageurlsEntity> imageurls = item.imageurls;


        String time = StringUtils.getStr(item.pubDate);
        String desc = StringUtils.getStr(item.desc);
        tvDes.setText(desc);
        int length = time.length();
        if(length >5){
            time=time.substring(5,length);
        }
        String source = StringUtils.getStr(item.source);
        tvTime.setText(time);
        tvSource.setText(source);
        tvTitle.setText(title);
    }

    private void setDataOne(BaseRecyclerHolder holder, ContentlistEntity item) {
        TextView tvTime = holder.getView(R.id.tv_time);
        TextView tvTitle = holder.getView(R.id.tv_title);
        TextView tvSource = holder.getView(R.id.tv_source);
        ImageView iv = holder.getView(R.id.iv);

        String title = StringUtils.getStr(item.title);
        List<ContentlistEntity.ImageurlsEntity> imageurls = item.imageurls;
        boolean havePic = item.havePic;
        String picUrl = null;
        if (!ListUtils.isEmpty(imageurls)) {//有图片
            picUrl = StringUtils.getStr(imageurls.get(0).url);
        } else {//没有图片

        }

        String time = StringUtils.getStr(item.pubDate);
        int length = time.length();
        if(length >5){
            time=time.substring(5,length-3);
        }
        String source = StringUtils.getStr(item.source);
        tvTime.setText(time);
        tvSource.setText(source);
        tvTitle.setText(title);
        // 是否开启智能无图模式，true表示开启智能无图模式
        boolean isIntelligentNoPic = SPUtils.getBoolean(Constants.SPConstants.isIntelligentNoPic);
        //            WriteLogUtil.i("isIntelligentNoPic=" + isIntelligentNoPic);
        if (isIntelligentNoPic) {
            if (APP.getInstance().isWifi()) {
                display(iv, havePic, picUrl);

            } else {
                iv.setImageDrawable(new ColorDrawable(Color.GRAY));
            }

        } else {
            display(iv, havePic, picUrl);
        }
    }

    private void display(ImageView iv, boolean havePic, String picUrl) {
        if (havePic) {
            ImageRequestManager.getInstance().display(mContext, iv, picUrl);
        } else {
            ImageRequestManager.getInstance().display(mContext, iv, UriUtils.resourceIdToUri
                    (mContext, R.mipmap.tangyang7));
        }
    }
}
