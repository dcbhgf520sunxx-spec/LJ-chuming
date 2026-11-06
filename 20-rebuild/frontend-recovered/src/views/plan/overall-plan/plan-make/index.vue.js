import { ref as B } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as H } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as i } from "vue";
import { unref as l } from "vue";
import { Fragment as D } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as u } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as p } from "vue";
import { createTextVNode as j } from "vue";
import { toDisplayString as v } from "vue";
import { renderList as T } from "vue";
import { createElementVNode as g } from "vue";
import { normalizeClass as A } from "vue";
import { createVNode as O } from "vue";
import { ElMessage as x } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { ElDatePicker as te } from "element-plus";
import { vLoading as ae } from "element-plus";
import { c as J } from "../../../../modules/plan-make-b1cab552.js";
import { _ as re, m as le, x as se, o as ie, sX as S, T as ne, i as y, mw as oe, p as L, bN as R, P as de, c7 as me } from "../../../../shared/runtime.js";
import { g as F } from "../../../../modules/plan-d12d7ccf.js";
const ce = { class: "app-container" }, pe = { key: 1, class: "sandwich-cell-bottom" }, ue = { key: 1, class: "sandwich-cell-bottom" }, ye = { key: 1, class: "sandwich-cell-bottom" }, he = { key: 1, class: "sandwich-cell-bottom" }, fe = { key: 1, class: "sandwich-cell-bottom" }, De = { key: 1, class: "sandwich-cell-bottom" }, Ve = { key: 1, class: "sandwich-cell-bottom" }, ge = { key: 1, class: "sandwich-cell-bottom" }, be = { key: 1, class: "sandwich-cell-bottom" }, we = { key: 1, style: { color: "red", "font-size": "14px" } }, _e = { __name: "index", setup(Le) {
  const { globalProject: w, globalProjectId: P } = le(["globalProject", "globalProjectId"]), Y = { add: false, edit: false, del: false, download: false }, z = B(), M = B({}), { crud: C, columns: _, CRUD: U } = se({ title: "区域计划", sort: ["sort.asc", "id.desc"], permission: { ...F.value }, optShow: { ...Y }, requiredQuery: ["projectId"], crudApi: { ...J }, hasPagination: true, queryOnPresenterCreated: false }, z), { maxHeight: K } = ie({ wrapperBox: ".plan-make", paginate: true, extraHeight: 40 });
  Z(() => P.value, (s) => {
    s && (C.query.projectId = P.value, setTimeout(() => {
      C.toQuery();
    }, 10));
  }, { immediate: true, deep: true });
  function Q({ row: s, column: o, rowIndex: c, columnIndex: h }) {
    if (h === 0) return s.monomerNameSpan ? { rowspan: s.monomerNameSpan, colspan: 1 } : { rowspan: 0, colspan: 1 };
  }
  function G(s, o) {
    M.value = JSON.parse(JSON.stringify(s.areaList[o])), s.areaList[o].isModify = true, console.log(s.areaList[o]);
  }
  function X(s, o) {
    s.areaList[o] = Object.assign(s.areaList[o], JSON.parse(JSON.stringify(M.value))), s.areaList[o].isModify = false;
  }
  function E(s, o) {
    y(s.timeArr) ? (s.startDate = s.timeArr[0], s.endDate = s.timeArr[1]) : (s.startDate = void 0, s.endDate = void 0), $(o);
  }
  function $(s) {
    var h, V, N, f, I, t, e, n, d, m;
    const o = ((h = s.deepVal) == null ? void 0 : h.startDate) || ((V = s.purchaseVal) == null ? void 0 : V.startDate) || ((N = s.processVal) == null ? void 0 : N.startDate) || ((f = s.deliveryVal) == null ? void 0 : f.startDate) || ((I = s.installVal) == null ? void 0 : I.startDate) || void 0, c = ((t = s.installVal) == null ? void 0 : t.endDate) || ((e = s.deliveryVal) == null ? void 0 : e.endDate) || ((n = s.processVal) == null ? void 0 : n.endDate) || ((d = s.purchaseVal) == null ? void 0 : d.endDate) || ((m = s.deepVal) == null ? void 0 : m.endDate) || void 0;
    o && c && (s.totalDays = me(o, c));
  }
  async function W(s, o) {
    if (!y(s.areaList[o].deepVal.timeArr)) {
      x.error("深化计划必填");
      return;
    }
    if (!y(s.areaList[o].processVal.timeArr)) {
      x.error("生产计划必填");
      return;
    }
    if (!y(s.areaList[o].deliveryVal.timeArr)) {
      x.error("发运计划必填");
      return;
    }
    if (w.value.businessType === R.INSTALLATION.V && y(M.value.installVal.timeArr) && !y(s.areaList[o].installVal.timeArr)) {
      x.error("安装计划必填");
      return;
    }
    try {
      const c = [{ ...s.areaList[o].deepVal }, { ...s.areaList[o].processVal }, { ...s.areaList[o].deliveryVal }, { ...s.areaList[o].purchaseVal }];
      w.value.businessType === R.INSTALLATION.V && c.push({ ...s.areaList[o].installVal }), await J.edit(s.areaList[o].id, c), C.notify("修改成功", U.NOTIFICATION_TYPE.SUCCESS), s.areaList[o].isModify = false;
    } catch (c) {
      console.log("修改", c);
    }
  }
  return U.HOOK.handleRefresh = (s, o) => {
    const c = [];
    o.data.content.map((h) => {
      h.monomerDetailList.length > 0 && h.monomerDetailList.map((V, N) => {
        V.startDate = h.startDate, V.monomerName = h.name, N === 0 && (V.monomerNameSpan = h.monomerDetailList.length), V.areaList && V.areaList.length > 0 && V.areaList.map((f, I) => {
          const t = f.planDetailList.find((r) => r.type === S.DEEPEN.V), e = f.planDetailList.find((r) => r.type === S.PROCESS.V), n = f.planDetailList.find((r) => r.type === S.INSTALL.V), d = f.planDetailList.find((r) => r.type === S.DELIVERY.V) || {}, m = f.planDetailList.find((r) => r.type === S.PURCHASE.V) || {};
          t && (t.timeArr = [], t.startDate && t.endDate && (t.timeArr = [t.startDate, t.endDate])), e && (e.timeArr = [], e.startDate && e.endDate && (e.timeArr = [e.startDate, e.endDate])), n && n.startDate && n.endDate && (n.timeArr = [], n.startDate && n.endDate && (n.timeArr = [n.startDate, n.endDate])), d && (d.timeArr = [], d.type = S.DELIVERY.V, d.startDate && d.endDate && (d.timeArr = [d.startDate, d.endDate])), m && (m.timeArr = [], m.startDate && m.endDate && (m.timeArr = [m.startDate, m.endDate])), f.deepVal = t, f.processVal = e, f.installVal = n, f.deliveryVal = d, f.purchaseVal = m, $(f);
        }), c.push(V);
      });
    }), o.data.content = c || [];
  }, U.HOOK.beforeSubmit = () => (C.form.projectId = P.value, !!C.form.projectId), (s, o) => {
    const c = ee, h = te, V = H("common-button"), N = H("common-table"), f = k("permission"), I = ae;
    return a(), i("div", ce, [l(w) && l(w).projectContentList && l(w).projectContentList.length > 0 ? (a(), i(D, { key: 0 }, [q((a(), u(N, { ref_key: "tableRef", ref: z, data: l(C).data, "empty-text": l(C).emptyText, "max-height": l(K), "return-source-data": "", showEmptySymbol: false, stripe: false, class: "upload-table", style: { width: "100%" }, "span-method": Q }, { default: b(() => [l(_).visible("monomerName") ? (a(), u(c, { key: "monomerName", prop: "monomerName", align: "center", "show-overflow-tooltip": true, label: "单体" })) : p("", true), l(_).visible("content") ? (a(), u(c, { key: "content", prop: "content", label: "项目内容", align: "center", width: "70" }, { default: b((t) => [j(v(t.row.type ? l(ne).VL[t.row.type] : "-"), 1)]), _: 1 })) : p("", true), l(_).visible("unit") ? (a(), u(c, { key: "unit", prop: "unit", label: "单元", align: "center" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => (a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, v(e.name), 3)]))), 128)) : (a(), i("div", pe))]), _: 1 })) : p("", true), l(_).visible("type") ? (a(), u(c, { key: "type", prop: "type", label: "生产方式", width: "70", align: "center" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => (a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, v(l(y)(e.type) ? l(oe).VL[e.type] : "-"), 3)]))), 128)) : (a(), i("div", ue))]), _: 1 })) : p("", true), l(_).visible("deepen") ? (a(), u(c, { key: "deepen", prop: "deepen", label: "深化计划", align: "center", "min-width": "150" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => {
      var d, m;
      return a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [l(y)(e.deepVal) ? (a(), i(D, { key: 0 }, [e.isModify ? (a(), u(h, { key: 0, modelValue: e.deepVal.timeArr, "onUpdate:modelValue": (r) => e.deepVal.timeArr = r, type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始", "end-placeholder": "结束", onChange: (r) => E(e.deepVal, e), disabledDate: (r) => (t.row.startDate ? r.getTime() < t.row.startDate : r.getTime() < l(w).startDate) || r.getTime() > e.date }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange", "disabledDate"])) : p("", true), g("span", null, v((d = e.deepVal) != null && d.startDate && ((m = e.deepVal) != null && m.endDate) ? l(L)(e.deepVal.startDate, "{y}-{m}-{d}") + " : " + l(L)(e.deepVal.endDate, "{y}-{m}-{d}") : "-"), 1)], 64)) : p("", true)], 2)]);
    }), 128)) : (a(), i("div", ye))]), _: 1 })) : p("", true), l(_).visible("purchase") ? (a(), u(c, { key: "purchase", prop: "purchase", align: "center", label: "采购计划", "min-width": "150" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => {
      var d, m;
      return a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [l(y)(e.purchaseVal) ? (a(), i(D, { key: 0 }, [e.isModify ? (a(), u(h, { key: 0, modelValue: e.purchaseVal.timeArr, "onUpdate:modelValue": (r) => e.purchaseVal.timeArr = r, type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始", "end-placeholder": "结束", onChange: (r) => E(e.purchaseVal, e), disabled: !l(y)(e.deepVal.timeArr), disabledDate: (r) => e.deepVal.startDate ? r.getTime() < e.deepVal.startDate || r.getTime() > e.date : (t.row.startDate ? r.getTime() < t.row.startDate : r.getTime() < l(w).startDate) || r.getTime() > e.date }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange", "disabled", "disabledDate"])) : p("", true), g("span", null, v((d = e.purchaseVal) != null && d.startDate && ((m = e.purchaseVal) != null && m.endDate) ? l(L)(e.purchaseVal.startDate, "{y}-{m}-{d}") + " : " + l(L)(e.purchaseVal.endDate, "{y}-{m}-{d}") : "-"), 1)], 64)) : p("", true)], 2)]);
    }), 128)) : (a(), i("div", he))]), _: 1 })) : p("", true), l(_).visible("process") ? (a(), u(c, { key: "process", prop: "process", label: "加工计划", align: "center", "min-width": "150" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => {
      var d, m;
      return a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [l(y)(e.processVal) ? (a(), i(D, { key: 0 }, [e.isModify ? (a(), u(h, { key: 0, modelValue: e.processVal.timeArr, "onUpdate:modelValue": (r) => e.processVal.timeArr = r, type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始", "end-placeholder": "结束", onChange: (r) => E(e.processVal, e), disabled: !l(y)(e.deepVal.timeArr), disabledDate: (r) => e.deepVal.startDate ? r.getTime() < e.deepVal.startDate || r.getTime() > e.date : (t.row.startDate ? r.getTime() < t.row.startDate : r.getTime() < l(w).startDate) || r.getTime() > e.date }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange", "disabled", "disabledDate"])) : p("", true), g("span", null, v((d = e.processVal) != null && d.startDate && ((m = e.processVal) != null && m.endDate) ? l(L)(e.processVal.startDate, "{y}-{m}-{d}") + " : " + l(L)(e.processVal.endDate, "{y}-{m}-{d}") : "-"), 1)], 64)) : p("", true)], 2)]);
    }), 128)) : (a(), i("div", fe))]), _: 1 })) : p("", true), l(_).visible("delivery") ? (a(), u(c, { key: "delivery", prop: "delivery", label: "发运计划", align: "center", "min-width": "150" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => {
      var d, m;
      return a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [l(y)(e.deliveryVal) ? (a(), i(D, { key: 0 }, [e.isModify ? (a(), u(h, { key: 0, modelValue: e.deliveryVal.timeArr, "onUpdate:modelValue": (r) => e.deliveryVal.timeArr = r, type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始", "end-placeholder": "结束", onChange: (r) => E(e.deliveryVal, e), disabled: !l(y)(e.processVal.timeArr), disabledDate: (r) => e.processVal.startDate ? r.getTime() < e.processVal.startDate || r.getTime() > e.date : (t.row.startDate ? r.getTime() < t.row.startDate : r.getTime() < l(w).startDate) || r.getTime() > e.date }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange", "disabled", "disabledDate"])) : p("", true), g("span", null, v((d = e.deliveryVal) != null && d.startDate && ((m = e.deliveryVal) != null && m.endDate) ? l(L)(e.deliveryVal.startDate, "{y}-{m}-{d}") + " : " + l(L)(e.deliveryVal.endDate, "{y}-{m}-{d}") : "-"), 1)], 64)) : p("", true)], 2)]);
    }), 128)) : (a(), i("div", De))]), _: 1 })) : p("", true), l(_).visible("install") && l(w).businessType === l(R).INSTALLATION.V ? (a(), u(c, { key: "install", prop: "install", label: "安装计划", align: "center", "min-width": "150" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => {
      var d, m;
      return a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [l(y)(e.installVal) ? (a(), i(D, { key: 0 }, [e.isModify ? (a(), u(h, { key: 0, modelValue: e.installVal.timeArr, "onUpdate:modelValue": (r) => e.installVal.timeArr = r, type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始", "end-placeholder": "结束", onChange: (r) => E(e.installVal, e), disabled: !(l(y)(e.processVal.timeArr) && l(y)(e.deepVal.timeArr)), disabledDate: (r) => e.deliveryVal.startDate ? r.getTime() < e.deliveryVal.startDate || r.getTime() > e.date : (t.row.startDate ? r.getTime() < t.row.startDate : r.getTime() < l(w).startDate) || r.getTime() > e.date }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange", "disabled", "disabledDate"])) : p("", true), g("span", null, v((d = e.installVal) != null && d.startDate && ((m = e.installVal) != null && m.endDate) ? l(L)(e.installVal.startDate, "{y}-{m}-{d}") + " : " + l(L)(e.installVal.endDate, "{y}-{m}-{d}") : "-"), 1)], 64)) : p("", true)], 2)]);
    }), 128)) : (a(), i("div", Ve))]), _: 1 })) : p("", true), l(_).visible("totalDays") ? (a(), u(c, { key: "totalDays", prop: "totalDays", label: "用时(天)", align: "center" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => (a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, v(e.totalDays ? e.totalDays : "-"), 3)]))), 128)) : (a(), i("div", ge))]), _: 1 })) : p("", true), O(c, { label: "操作", width: "160px", align: "center", fixed: "right" }, { default: b((t) => [t.row.areaList.length > 0 ? (a(true), i(D, { key: 0 }, T(t.row.areaList, (e, n) => (a(), i("div", { key: e.id }, [g("div", { class: A(n === t.row.areaList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.isModify ? (a(), i(D, { key: 0 }, [O(V, { type: "info", size: "default", onClick: (d) => X(t.row, n) }, { default: b(() => o[0] || (o[0] = [j("取消")])), _: 2, __: [0] }, 1032, ["onClick"]), O(V, { type: "primary", size: "default", onClick: (d) => W(t.row, n) }, { default: b(() => o[1] || (o[1] = [j("保存")])), _: 2, __: [1] }, 1032, ["onClick"])], 64)) : q((a(), u(V, { key: 1, size: "default", onClick: (d) => G(t.row, n), icon: "el-icon-edit", type: "primary" }, null, 8, ["onClick"])), [[f, l(F).edit]])], 2)]))), 128)) : (a(), i("div", be))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[I, l(C).loading]]), O(l(de))], 64)) : (a(), i("div", we, "*请先前去合同管理模块添加项目内容"))]);
  };
} }, Ne = re(_e, [["__scopeId", "data-v-d209bf65"]]);
export {
  Ne as default
};
