import { ref as O } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as h } from "vue";
import { unref as t } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as u } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as c } from "vue";
import { toDisplayString as l } from "vue";
import { withModifiers as V } from "vue";
import { ElMessageBox as S } from "element-plus";
import { ElNotification as j } from "element-plus";
import { ElMessage as z } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElSwitch as Q } from "element-plus";
import { vLoading as X } from "element-plus";
import { c as Y, m as G, e as I, d as K } from "./module/form.vue.js";
import { _ as Z, x as ee, s4 as L, o as te, i as g, qp as ae, sa as oe, e0 as q, e1 as B, bV as W, aS as y, G as v, P as se } from "../../../../shared/runtime.js";
import ie from "./module/header.vue.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
const ne = { class: "app-container" }, le = { class: "head-container" }, re = { key: 0 }, ue = { key: 1 }, ce = { key: 0 }, de = { key: 1 }, pe = { key: 0, class: "detailList" }, me = { key: 1 }, we = { key: 0, class: "detailList" }, _e = { key: 1 }, be = { key: 0 }, fe = { key: 1 }, he = { __name: "index", setup(ye) {
  const R = { add: true, edit: false, del: false, download: false }, C = O(), x = O(), { crud: w, columns: p, CRUD: M } = ee({ title: "部件定额", permission: { ...L }, optShow: { ...R }, crudApi: { ...Y }, hasPagination: true }, C), { maxHeight: H } = te({ paginate: true });
  M.HOOK.handleRefresh = (n, s) => {
    x.value = JSON.parse(JSON.stringify(s.data.content)), s.data.content.forEach((a) => {
      (!a.detailList || !a.detailList.length) && (a.detailList = [{ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 }]);
    }), s.data.content = s.data.content.flatMap((a, b) => {
      var _;
      return (_ = a == null ? void 0 : a.detailList) == null ? void 0 : _.map((f) => ({ ...a, index: b + 1, detailList: f }));
    });
  };
  async function $(n, s) {
    console.log(n, s);
    try {
      await S.confirm(`此操作将 ${n.quotaNumber} 的状态改为 ${y.VL[s]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await I({ id: n.id, status: s }), w.toQuery(), j({ title: `${n.quotaNumber}的状态修改成功`, type: "success", duration: 3e3 });
    } catch (a) {
      console.log("变更是否固定资产折旧失败", a), n.status = n.status === y.TRUE.V ? y.FALSE.V : y.TRUE.V;
    }
  }
  async function D(n) {
    try {
      await S.confirm(`确认将 ${n.quotaNumber} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await K({ id: n.id }), z.success("删除成功！"), w.refresh();
    } catch (s) {
      console.log(s);
    }
  }
  function P(n) {
    var a;
    let s = {};
    (a = x.value) == null || a.forEach((b) => {
      b.quotaNumber === n.quotaNumber && (s = b);
    }), w.toEdit(s);
  }
  const U = ["index", "quotaNumber", "workshopNameList", "calculationWay", "assembleClassNameList", "processName", "boolSpecificationClass", "status", "operation"];
  function A({ row: n, column: s, rowIndex: a, columnIndex: b }) {
    if (U.includes(s.property)) {
      const _ = n.quotaNumber || "", f = w.data[a - 1], k = f ? f.quotaNumber : null;
      if (_ === k) return { rowspan: 0, colspan: 0 };
      {
        let e = 1;
        for (let i = a + 1; i < w.data.length; i++) {
          const E = w.data[i].quotaNumber || "";
          if (E && _ && E === _) e++;
          else break;
        }
        return { rowspan: e, colspan: 1 };
      }
    }
  }
  return (n, s) => {
    const a = J, b = Q, _ = T("common-button"), f = T("common-table"), k = X;
    return o(), d("div", ne, [r("div", le, [h(t(ie))]), F((o(), u(f, { ref_key: "tableRef", ref: C, data: t(w).data, "empty-text": t(w).emptyText, "max-height": t(H), style: { width: "100%" }, "span-method": A }, { default: m(() => [h(a, { label: "序号", prop: "index", align: "center", width: "60" }), t(p).visible("quotaNumber") ? (o(), u(a, { key: "quotaNumber", prop: "quotaNumber", "show-overflow-tooltip": true, label: "定额编号", align: "center" })) : c("", true), t(p).visible("workshopNameList") ? (o(), u(a, { key: "workshopNameList", prop: "workshopNameList", "show-overflow-tooltip": true, label: "车间", align: "center" }, { default: m((e) => [t(g)(e.row.workshopNameList) ? (o(), d("span", re, l(e.row.workshopNameList.join("、")), 1)) : (o(), d("span", ue, "-"))]), _: 1 })) : c("", true), t(p).visible("assembleClassNameList") ? (o(), u(a, { key: "assembleClassNameList", prop: "assembleClassNameList", "show-overflow-tooltip": true, label: "部件类型", align: "center" }, { default: m((e) => [t(g)(e.row.assembleClassNameList) ? (o(), d("span", ce, l(e.row.assembleClassNameList.join("、")), 1)) : (o(), d("span", de, "-"))]), _: 1 })) : c("", true), t(p).visible("processName") ? (o(), u(a, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序", align: "center" })) : c("", true), t(p).visible("calculationWay") ? (o(), u(a, { key: "calculationWay", prop: "calculationWay", label: "计算方式", align: "center" }, { default: m((e) => [r("span", null, l(t(ae).VL[e.row.calculationWay] || "-"), 1)]), _: 1 })) : c("", true), t(p).visible("classificationWayEnum") ? (o(), u(a, { key: "classificationWayEnum", prop: "classificationWayEnum", label: "分类方式", align: "center" }, { default: m((e) => [r("span", null, l(t(oe).VL[e.row.classificationWayEnum] || "-"), 1)]), _: 1 })) : c("", true), t(p).visible("detailList") ? (o(), u(a, { key: "detailList", prop: "detailList", "show-overflow-tooltip": true, label: "截面分类（mm）", align: "center" }, { default: m((e) => {
      var i;
      return [t(g)((i = e.row.detailList) == null ? void 0 : i.sectionHeightNumberOne) ? (o(), d("div", pe, [r("span", null, l(e.row.detailList.sectionHeightNumberOne), 1), r("span", null, l(t(q).VL[e.row.detailList.sectionHeightComparisonOperatorOne]), 1), s[0] || (s[0] = r("span", null, "X", -1)), r("span", null, l(t(B).VL[e.row.detailList.sectionHeightComparisonOperatorTwo]), 1), r("span", null, l(e.row.detailList.sectionHeightNumberTwo), 1)])) : (o(), d("span", me, "-"))];
    }), _: 1 })) : c("", true), t(p).visible("detailList") ? (o(), u(a, { key: "detailList", prop: "detailList", "show-overflow-tooltip": true, label: "腹板厚度（mm）", align: "center" }, { default: m((e) => {
      var i;
      return [t(g)((i = e.row.detailList) == null ? void 0 : i.webThicknessNumberOne) ? (o(), d("div", we, [r("span", null, l(e.row.detailList.webThicknessNumberOne), 1), r("span", null, l(t(q).VL[e.row.detailList.webThicknessComparisonOperatorOne]), 1), s[1] || (s[1] = r("span", null, "X", -1)), r("span", null, l(t(B).VL[e.row.detailList.webThicknessComparisonOperatorTwo]), 1), r("span", null, l(e.row.detailList.webThicknessNumberTwo), 1)])) : (o(), d("span", _e, "-"))];
    }), _: 1 })) : c("", true), t(p).visible("price") ? (o(), u(a, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价（元）", align: "center" }, { default: m((e) => {
      var i, N;
      return [(i = e.row.detailList) != null && i.price ? (o(), d("span", be, l(t(W)((N = e.row.detailList) == null ? void 0 : N.price)), 1)) : (o(), d("span", fe, l(t(W)(e.row.price)), 1))];
    }), _: 1 })) : c("", true), t(p).visible("status") ? (o(), u(a, { key: "status", prop: "status", label: "状态", align: "center" }, { default: m((e) => [h(b, { modelValue: e.row.status, "onUpdate:modelValue": (i) => e.row.status = i, "active-value": t(y).TRUE.V, "inactive-value": t(y).FALSE.V, disabled: !t(v)(t(L).status) || !e.row.status, onChange: (i) => $(e.row, e.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 })) : c("", true), h(a, { label: "操作", prop: "operation", align: "center" }, { default: m((e) => [t(v)(t(L).edit) && e.row.status ? (o(), u(_, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: V((i) => P(e.row), ["stop"]) }, null, 8, ["onClick"])) : c("", true), t(v)(t(L).del) && e.row.status ? (o(), u(_, { key: 1, icon: "el-icon-delete", size: "default", type: "danger", onClick: V((i) => D(e.row), ["stop"]) }, null, 8, ["onClick"])) : c("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[k, t(w).loading]]), h(t(G)), h(t(se))]);
  };
} }, Oe = Z(he, [["__scopeId", "data-v-0303638e"]]);
export {
  Oe as default
};
