package protect.videotranscoder.report;

/*
 * Created by Christian Schabesberger  on 13.09.16.
 *
 * Copyright (C) Christian Schabesberger 2015 <chris.schabesberger@mailbox.org>
 * AcraReportSender.java is originally part of NewPipe.
 *
 * NewPipe is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NewPipe is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NewPipe.  If not, see <http://www.gnu.org/licenses/>.
 */

import android.content.Context;

import androidx.annotation.NonNull;

import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

import protect.videotranscoder.R;

public class AcraReportSender implements ReportSender
{
    @Override
    public void send(@NonNull Context context, @NonNull CrashReportData report) throws ReportSenderException
    {
        ErrorActivity.reportError(context, report,
                ErrorActivity.ErrorInfo.make(UserAction.UI_ERROR,"none",
                        "App crash, UI failure", R.string.app_ui_crash));
    }
}
