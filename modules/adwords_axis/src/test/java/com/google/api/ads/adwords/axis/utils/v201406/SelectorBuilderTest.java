// Copyright 2014 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.axis.utils.v201406;

import com.google.api.ads.adwords.axis.v201406.cm.CampaignStatus;
import com.google.api.ads.adwords.axis.v201406.cm.DateRange;
import com.google.api.ads.adwords.axis.v201406.cm.OrderBy;
import com.google.api.ads.adwords.axis.v201406.cm.Predicate;
import com.google.api.ads.adwords.axis.v201406.cm.PredicateOperator;
import com.google.api.ads.adwords.axis.v201406.cm.Selector;
import com.google.api.ads.adwords.axis.v201406.cm.SortOrder;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Test case for the Axis implementation of the selector builder.
 *
 * @author Gustavo Moreira
 */
@RunWith(JUnit4.class)
public class SelectorBuilderTest {

  /**
   * Tests the immutability of the selector
   */
  @Test
  @SuppressWarnings("unchecked")
  public void testSelctorBuilderImmutability() {
    DateFormat dateFormat = new SimpleDateFormat(SelectorBuilder.DEFAULT_DATE_FORMAT);

    SelectorBuilder builder = new SelectorBuilder();

    DateTime start = new DateTime(2013, 3, 25, 0, 0, 0, 0);
    DateTime end = new DateTime(2013, 3, 26, 0, 0, 0, 0);
    String formatStart = dateFormat.format(start.toDate());
    String formatEnd = dateFormat.format(end.toDate());

    builder = builder.fields("Id", "Name", "Status").forDateRange(start, end);

    Selector selector = builder.build();

    Assert.assertEquals(selector.getDateRange().getMin(), formatStart);
    Assert.assertEquals(selector.getDateRange().getMax(), formatEnd);

    String formatEndPlusOne = dateFormat.format(end.plusDays(1).toDate());

    DateRange dateRange = new DateRange();
    dateRange.setMin(formatStart);
    dateRange.setMax(formatEndPlusOne);

    selector.setDateRange(dateRange);

    Assert.assertEquals(selector.getDateRange().getMin(), formatStart);
    Assert.assertEquals(selector.getDateRange().getMax(), formatEndPlusOne);

    Selector selectorRebuilt =
        builder.fields("Id", "Name", "Status").forDateRange(start, end).build();

    Assert.assertEquals(selectorRebuilt.getDateRange().getMin(), formatStart);
    Assert.assertEquals(selectorRebuilt.getDateRange().getMax(), formatEnd);

  }

  /**
   * Tests the adding of a new field
   */
  @Test
  @SuppressWarnings("unchecked")
  public void testFieldsBuild() {
    SelectorBuilder builder = new SelectorBuilder();

    builder =
        builder.fields("Id", "Name", "Status", "StartDate", "EndDate", "ServingStatus", "Settings");

    Selector selector = builder.build();

    Assert.assertEquals(7, selector.getFields().length);

    Assert.assertEquals("Id", selector.getFields()[0]);
    Assert.assertEquals("Name", selector.getFields()[1]);
    Assert.assertEquals("Status", selector.getFields()[2]);
    Assert.assertEquals("StartDate", selector.getFields()[3]);
    Assert.assertEquals("EndDate", selector.getFields()[4]);
    Assert.assertEquals("ServingStatus", selector.getFields()[5]);
    Assert.assertEquals("Settings", selector.getFields()[6]);

    selector = builder.fields("Id",
        "Name",
        "Status",
        "StartDate",
        "EndDate",
        "ServingStatus",
        "Settings",
        "Id",
        "AverageCpc").build();

    Assert.assertEquals(8, selector.getFields().length);

    Assert.assertEquals("Id", selector.getFields()[0]);
    Assert.assertEquals("Name", selector.getFields()[1]);
    Assert.assertEquals("Status", selector.getFields()[2]);
    Assert.assertEquals("StartDate", selector.getFields()[3]);
    Assert.assertEquals("EndDate", selector.getFields()[4]);
    Assert.assertEquals("ServingStatus", selector.getFields()[5]);
    Assert.assertEquals("Settings", selector.getFields()[6]);
    Assert.assertEquals("AverageCpc", selector.getFields()[7]);

  }


  /**
   * Tests the removal of a new field
   */
  @Test
  @SuppressWarnings("unchecked")
  public void testFieldsRemove() {
    SelectorBuilder builder = new SelectorBuilder();

    builder =
        builder.fields("Id", "Name", "Status", "StartDate", "EndDate", "ServingStatus", "Settings");

    Selector selector = builder.build();

    Assert.assertEquals(7, selector.getFields().length);

    Assert.assertEquals("Id", selector.getFields()[0]);
    Assert.assertEquals("Name", selector.getFields()[1]);
    Assert.assertEquals("Status", selector.getFields()[2]);
    Assert.assertEquals("StartDate", selector.getFields()[3]);
    Assert.assertEquals("EndDate", selector.getFields()[4]);
    Assert.assertEquals("ServingStatus", selector.getFields()[5]);
    Assert.assertEquals("Settings", selector.getFields()[6]);

  }

  /**
   * Tests the predicate build for the ID field
   */
  @Test
  public void testPredicatesBuild() {
    SelectorBuilder builder = new SelectorBuilder();

    builder = builder.equalsId(10L);
    Selector selector = builder.build();

    Assert.assertNotNull(selector.getPredicates());
    Assert.assertEquals(1, selector.getPredicates().length);

    Predicate predicate = selector.getPredicates()[0];
    Assert.assertEquals("Id", predicate.getField());
    Assert.assertEquals(PredicateOperator.EQUALS, predicate.getOperator());
    Assert.assertNotNull(predicate.getValues());
    Assert.assertEquals(1, predicate.getValues().length);
    Assert.assertEquals("10", predicate.getValues()[0]);

  }

  /**
   * Tests the predicate with the IN clause
   */
  @Test
  public void testPredicatesInBuild() {
    SelectorBuilder builder = new SelectorBuilder();

    builder =
        builder.in("Status", CampaignStatus.ENABLED.toString(), CampaignStatus.REMOVED.toString());
    Selector selector = builder.build();

    Assert.assertNotNull(selector.getPredicates());
    Assert.assertEquals(1, selector.getPredicates().length);

    Predicate predicate = selector.getPredicates()[0];
    Assert.assertEquals("Status", predicate.getField());
    Assert.assertEquals(PredicateOperator.IN, predicate.getOperator());
    Assert.assertNotNull(predicate.getValues());
    Assert.assertEquals(2, predicate.getValues().length);
    Assert.assertEquals(CampaignStatus.ENABLED.toString(), predicate.getValues()[0]);
    Assert.assertEquals(CampaignStatus.REMOVED.toString(), predicate.getValues()[1]);

  }

  /**
   * Tests the order by criteria
   */
  @Test
  public void testOrderByBuild() {
    SelectorBuilder builder = new SelectorBuilder();

    builder = builder.orderAscBy("AverageCpm");
    Selector selector = builder.build();

    Assert.assertNotNull(selector.getOrdering());
    Assert.assertEquals(1, selector.getOrdering().length);

    OrderBy orderBy = selector.getOrdering()[0];

    Assert.assertEquals("AverageCpm", orderBy.getField());
    Assert.assertEquals(SortOrder.ASCENDING, orderBy.getSortOrder());

    builder.orderAscBy("AverageCpm").orderDescBy("AverageCpc");
    selector = builder.build();

    Assert.assertNotNull(selector.getOrdering());
    Assert.assertEquals(2, selector.getOrdering().length);

    orderBy = selector.getOrdering()[0];

    Assert.assertEquals("AverageCpm", orderBy.getField());
    Assert.assertEquals(SortOrder.ASCENDING, orderBy.getSortOrder());

    orderBy = selector.getOrdering()[1];

    Assert.assertEquals("AverageCpc", orderBy.getField());
    Assert.assertEquals(SortOrder.DESCENDING, orderBy.getSortOrder());

    selector = builder.removeOrderBy("AverageCpm").build();

    Assert.assertNotNull(selector.getOrdering());
    Assert.assertEquals(1, selector.getOrdering().length);

    orderBy = selector.getOrdering()[0];

    Assert.assertEquals("AverageCpc", orderBy.getField());
    Assert.assertEquals(SortOrder.DESCENDING, orderBy.getSortOrder());

  }

  /**
   * Tests the date range setting
   */
  @Test
  public void testDateRangeBuild() {
    DateFormat dateFormat = new SimpleDateFormat(SelectorBuilder.DEFAULT_DATE_FORMAT);

    SelectorBuilder builder = new SelectorBuilder();

    DateTime start = new DateTime(2013, 3, 25, 0, 0, 0, 0);
    DateTime end = new DateTime(2013, 3, 26, 0, 0, 0, 0);
    String formatStart = dateFormat.format(start.toDate());
    String formatEnd = dateFormat.format(end.toDate());

    builder = builder.forDateRange(start, end);
    Selector selector = builder.build();

    Assert.assertEquals(selector.getDateRange().getMin(), formatStart);
    Assert.assertEquals(selector.getDateRange().getMax(), formatEnd);
  }

  /**
   * Tests the offset, limit and paging logic of the builder.
   */
  @Test
  public void testPagingAndLimits() {
    SelectorBuilder builder = new SelectorBuilder();

    builder = builder.offset(10);
    Selector selector = builder.build();

    Assert.assertNotNull(selector.getPaging());
    Assert.assertNotNull(selector.getPaging().getStartIndex());
    Assert.assertNull(selector.getPaging().getNumberResults());
    Assert.assertEquals(selector.getPaging().getStartIndex().intValue(), 10);

    selector = builder.offset(10).limit(20).build();

    Assert.assertNotNull(selector.getPaging());
    Assert.assertNotNull(selector.getPaging().getStartIndex());
    Assert.assertNotNull(selector.getPaging().getNumberResults());
    Assert.assertEquals(selector.getPaging().getStartIndex().intValue(), 10);
    Assert.assertEquals(selector.getPaging().getNumberResults().intValue(), 20);

    selector = builder.offset(10).limit(20).increaseOffsetBy(5).build();

    Assert.assertNotNull(selector.getPaging());
    Assert.assertNotNull(selector.getPaging().getStartIndex());
    Assert.assertNotNull(selector.getPaging().getNumberResults());
    Assert.assertEquals(selector.getPaging().getStartIndex().intValue(), 15);
    Assert.assertEquals(selector.getPaging().getNumberResults().intValue(), 20);

    selector = builder.offset(10).limit(20).increaseOffsetBy(5).removeLimitAndOffset().build();

    Assert.assertNull(selector.getPaging());

    selector = builder.offset(10)
        .limit(20)
        .increaseOffsetBy(5)
        .removeLimitAndOffset()
        .offset(55)
        .limit(4)
        .build();

    Assert.assertNotNull(selector.getPaging());
    Assert.assertNotNull(selector.getPaging().getStartIndex());
    Assert.assertNotNull(selector.getPaging().getNumberResults());
    Assert.assertEquals(selector.getPaging().getStartIndex().intValue(), 55);
    Assert.assertEquals(selector.getPaging().getNumberResults().intValue(), 4);

  }

  /**
   * Tests that the built selectors don't share internal Paging state.
   */
  @Test
  public void testUniqueInternalPagingState() {
    SelectorBuilder builder = new SelectorBuilder();
    Selector selectorOne = builder.fields("Id").offset(10).build();
    Selector selectorTwo = builder.fields("Status").offset(345).build();

    Assert.assertEquals(10, selectorOne.getPaging().getStartIndex().intValue());
    Assert.assertEquals(345, selectorTwo.getPaging().getStartIndex().intValue());
  }

  /**
   * Tests that the built selectors don't share internal OrderBy state.
   */
  @Test
  public void testUniqueInternalOrderByState() {
    SelectorBuilder builder = new SelectorBuilder();
    Selector selectorOne = builder.orderAscBy("Id").build();
    Selector selectorTwo = builder.build();

    OrderBy orderTwo = selectorTwo.getOrdering(0);
    orderTwo.setField("Status");

    Assert.assertEquals("Id", selectorOne.getOrdering(0).getField());
    Assert.assertEquals("Status", selectorTwo.getOrdering(0).getField());
  }

  /**
   * Tests that the built selectors don't share internal Predicate state.
   */
  @Test
  public void testUniqueInternalPredicateState() {
    SelectorBuilder builder = new SelectorBuilder();
    Selector selectorOne = builder.equals("Id", "test").build();
    Selector selectorTwo = builder.build();

    Predicate predicateTwo = selectorTwo.getPredicates(0);
    predicateTwo.setField("Status");

    Assert.assertEquals("Id", selectorOne.getPredicates(0).getField());
    Assert.assertEquals("Status", selectorTwo.getPredicates(0).getField());
  }

  /**
   * Tests that the built selectors don't share internal DateRange state.
   */
  @Test
  public void testUniqueInternalDateRangeState() {
    SelectorBuilder builder = new SelectorBuilder();
    DateFormat dateFormat = new SimpleDateFormat(SelectorBuilder.DEFAULT_DATE_FORMAT);

    DateTime startOne = new DateTime(2013, 1, 1, 0, 0, 0, 0);
    DateTime endOne = new DateTime(2013, 1, 31, 0, 0, 0, 0);
    DateTime startTwo = new DateTime(2013, 2, 1, 0, 0, 0, 0);
    DateTime endTwo = new DateTime(2013, 2, 28, 0, 0, 0, 0);

    Selector selectorOne = builder.forDateRange(startOne, endOne).build();
    Selector selectorTwo = builder.forDateRange(startTwo, endTwo).build();

    Assert.assertEquals(dateFormat.format(startOne.toDate()), selectorOne.getDateRange().getMin());
    Assert.assertEquals(dateFormat.format(endOne.toDate()), selectorOne.getDateRange().getMax());
    Assert.assertEquals(dateFormat.format(startTwo.toDate()), selectorTwo.getDateRange().getMin());
    Assert.assertEquals(dateFormat.format(endTwo.toDate()), selectorTwo.getDateRange().getMax());
  }

}
