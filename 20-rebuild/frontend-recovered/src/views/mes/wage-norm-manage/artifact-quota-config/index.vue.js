import { ref as O } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as h } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as u } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as c } from "vue";
import { toDisplayString as l } from "vue";
import { withModifiers as S } from "vue";
import { ElMessageBox as q } from "element-plus";
import { ElNotification as Q } from "element-plus";
import { ElMessage as Y } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElSwitch as z } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as J, e as X, d as K } from "../../../../modules/artifact-quota-config-9f8a0591.js";
import { _ as Z, x as ee, s2 as L, o as te, i as g, s9 as ae, qq as v, e0 as B, e1 as R, bV as M, aS as y, G as C, P as oe } from "../../../../shared/runtime.js";
import ie from "./module/form.vue.js";
import se from "./module/header.vue.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
const ne = { class: "app-container" }, le = { class: "head-container" }, re = { key: 0 }, ue = { key: 1 }, ce = { key: 0 }, de = { key: 1 }, pe = { key: 0, class: "detailList" }, me = { key: 1 }, fe = { key: 0, class: "detailList" }, _e = { key: 1 }, we = { key: 0 }, be = { key: 1 }, he = { __name: "index", setup(ye) {
  const A = { add: true, edit: false, del: false, download: false }, x = O(), V = O(), { crud: f, columns: p, CRUD: W } = ee({ title: "构件定额", permission: { ...L }, optShow: { ...A }, crudApi: { ...J }, hasPagination: true }, x), { maxHeight: P } = te({ paginate: true });
  W.HOOK.handleRefresh = (n, i) => {
    V.value = JSON.parse(JSON.stringify(i.data.content)), i.data.content.forEach((a) => {
      (!a.detailList || !a.detailList.length) && (a.detailList = [{ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 }]);
    }), i.data.content = i.data.content.flatMap((a, w) => {
      var _;
      return (_ = a == null ? void 0 : a.detailList) == null ? void 0 : _.map((b) => ({ ...a, index: w + 1, detailList: b }));
    });
  };
  async function U(n, i) {
    console.log(n, i);
    try {
      await q.confirm(`此操作将 ${n.quotaNumber} 的状态改为 ${y.VL[i]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await X({ id: n.id, status: i }), f.toQuery(), Q({ title: `${n.quotaNumber}的状态修改成功`, type: "success", duration: 3e3 });
    } catch (a) {
      console.log("变更是否固定资产折旧失败", a), n.status = n.status === y.TRUE.V ? y.FALSE.V : y.TRUE.V;
    }
  }
  async function $(n) {
    try {
      await q.confirm(`确认将 ${n.quotaNumber} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await K({ id: n.id }), Y.success("删除成功！"), f.refresh();
    } catch (i) {
      console.log(i);
    }
  }
  function D(n) {
    var a;
    let i = {};
    (a = V.value) == null || a.forEach((w) => {
      w.quotaNumber === n.quotaNumber && (i = w);
    }), f.toEdit(i);
  }
  const F = ["index", "quotaNumber", "workshopNameList", "calculationWay", "artifactClassNameList", "processName", "boolSpecificationClass", "status", "operation"];
  function H({ row: n, column: i, rowIndex: a, columnIndex: w }) {
    if (F.includes(i.property)) {
      const _ = n.quotaNumber || "", b = f.data[a - 1], k = b ? b.quotaNumber : null;
      if (_ === k) return { rowspan: 0, colspan: 0 };
      {
        let e = 1;
        for (let s = a + 1; s < f.data.length; s++) {
          const E = f.data[s].quotaNumber || "";
          if (E && _ && E === _) e++;
          else break;
        }
        return { rowspan: e, colspan: 1 };
      }
    }
  }
  return (n, i) => {
    const a = j, w = z, _ = T("common-button"), b = T("common-table"), k = G;
    return o(), d("div", ne, [r("div", le, [h(t(se))]), I((o(), u(b, { ref_key: "tableRef", ref: x, data: t(f).data, "empty-text": t(f).emptyText, "max-height": t(P), style: { width: "100%" }, showEmptySymbol: false, "span-method": H }, { default: m(() => [h(a, { label: "序号", prop: "index", align: "center", width: "60" }), t(p).visible("quotaNumber") ? (o(), u(a, { key: "quotaNumber", prop: "quotaNumber", "show-overflow-tooltip": true, label: "定额编号", align: "center" })) : c("", true), t(p).visible("workshopNameList") ? (o(), u(a, { key: "workshopNameList", prop: "workshopNameList", "show-overflow-tooltip": true, label: "车间", align: "center" }, { default: m((e) => [t(g)(e.row.workshopNameList) ? (o(), d("span", re, l(e.row.workshopNameList.join("、")), 1)) : (o(), d("span", ue, "-"))]), _: 1 })) : c("", true), t(p).visible("artifactClassNameList") ? (o(), u(a, { key: "artifactClassNameList", prop: "artifactClassNameList", "show-overflow-tooltip": true, label: "构件类型", align: "center" }, { default: m((e) => [t(g)(e.row.artifactClassNameList) ? (o(), d("span", ce, l(e.row.artifactClassNameList.join("、")), 1)) : (o(), d("span", de, "-"))]), _: 1 })) : c("", true), t(p).visible("processName") ? (o(), u(a, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序", align: "center" })) : c("", true), t(p).visible("boolSpecificationClass") ? (o(), u(a, { key: "boolSpecificationClass", prop: "boolSpecificationClass", label: "规格分类", align: "center" }, { default: m((e) => [r("span", null, l(t(ae).VL[e.row.boolSpecificationClass] || "-"), 1)]), _: 1 })) : c("", true), t(p).visible("calculationWay") ? (o(), u(a, { key: "calculationWay", prop: "calculationWay", label: "计算方式", align: "center" }, { default: m((e) => [r("span", null, l(t(v).VL[e.row.calculationWay] || "-"), 1)]), _: 1 })) : c("", true), t(p).visible("detailList") ? (o(), u(a, { key: "detailList", prop: "detailList", label: "构件重量分类", align: "center" }, { default: m((e) => {
      var s;
      return [e.row.calculationWay === t(v).ARTIFACT_WEIGHT.V && t(g)((s = e.row.detailList) == null ? void 0 : s.numberOne) ? (o(), d("div", pe, [r("span", null, l(e.row.detailList.numberOne), 1), r("span", null, l(t(B).VL[e.row.detailList.comparisonOperatorOne]), 1), i[0] || (i[0] = r("span", null, "X", -1)), r("span", null, l(t(R).VL[e.row.detailList.comparisonOperatorTwo]), 1), r("span", null, l(e.row.detailList.numberTwo), 1)])) : (o(), d("span", me, "-"))];
    }), _: 1 })) : c("", true), t(p).visible("detailList") ? (o(), u(a, { key: "detailList", prop: "detailList", "show-overflow-tooltip": true, label: "零件数量分类", align: "center" }, { default: m((e) => {
      var s;
      return [e.row.calculationWay === t(v).MACHINE_PART_QUANTITY.V && t(g)((s = e.row.detailList) == null ? void 0 : s.numberOne) ? (o(), d("div", fe, [r("span", null, l(e.row.detailList.numberOne), 1), r("span", null, l(t(B).VL[e.row.detailList.comparisonOperatorOne]), 1), i[1] || (i[1] = r("span", null, "X", -1)), r("span", null, l(t(R).VL[e.row.detailList.comparisonOperatorTwo]), 1), r("span", null, l(e.row.detailList.numberTwo), 1)])) : (o(), d("span", _e, "-"))];
    }), _: 1 })) : c("", true), t(p).visible("price") ? (o(), u(a, { key: "price", prop: "price", label: "单价（元）", align: "center" }, { default: m((e) => {
      var s, N;
      return [(s = e.row.detailList) != null && s.price ? (o(), d("span", we, l(t(M)((N = e.row.detailList) == null ? void 0 : N.price)), 1)) : (o(), d("span", be, l(t(M)(e.row.price)), 1))];
    }), _: 1 })) : c("", true), t(p).visible("status") ? (o(), u(a, { key: "status", prop: "status", label: "状态", align: "center" }, { default: m((e) => [h(w, { modelValue: e.row.status, "onUpdate:modelValue": (s) => e.row.status = s, "active-value": t(y).TRUE.V, "inactive-value": t(y).FALSE.V, disabled: !t(C)(t(L).status) || !e.row.status, onChange: (s) => U(e.row, e.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 })) : c("", true), h(a, { label: "操作", prop: "operation", align: "center" }, { default: m((e) => [t(C)(t(L).edit) && e.row.status ? (o(), u(_, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: S((s) => D(e.row), ["stop"]) }, null, 8, ["onClick"])) : c("", true), t(C)(t(L).del) && e.row.status ? (o(), u(_, { key: 1, icon: "el-icon-delete", size: "default", type: "danger", onClick: S((s) => $(e.row), ["stop"]) }, null, 8, ["onClick"])) : c("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[k, t(f).loading]]), h(t(ie)), h(t(oe))]);
  };
} }, Oe = Z(he, [["__scopeId", "data-v-424902fd"]]);
export {
  Oe as default
};
