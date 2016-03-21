/**
    United Projects Nurse Assistant App
        Copyright (C) 2016 United Projects
        Author: Louis Amhild, Pedro Olivares

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.
        package com.UnitedProjects,naa;
*/

package com.united.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class PatientDataInput extends View
{
    private String mId;
    private String mLabel;
    private String mType;
    private Paint mLabelPaint;

    public PatientDataInput(Context context)
    {
        super(context);
        init(null, 0);
    }

    public PatientDataInput(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(attrs, 0);
    }

    public PatientDataInput(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle)
    {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PatientDataInput, defStyle, 0);

        mLabel = a.getString(R.styleable.PatientDataInput_label);
        mId = a.getString(R.styleable.PatientDataInput_id);

        mLabelPaint = new Paint();
        mLabelPaint.setColor(0xffffffff);
        mLabelPaint.setAntiAlias(true);
        mLabelPaint.setTypeface(Typeface.MONOSPACE);
        mLabelPaint.setTextAlign(Paint.Align.CENTER);
        mLabelPaint.setTextSize(0.05f);
        mLabelPaint.setTextScaleX(0.8f);

        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawText(getLabel(), 0.45f, 0.95f, mLabelPaint);
    }

    private void drawTitle(Canvas canvas)
    {

    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
    public String getLabel()
    {
        return mLabel;
    }

    /**
     * Sets the label of the input field
     */
    public void setLabel(String label)
    {
        mLabel = label;
    }
}
