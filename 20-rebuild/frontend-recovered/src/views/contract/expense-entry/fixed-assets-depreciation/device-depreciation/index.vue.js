import { ref as y } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as U } from "vue";
import { unref as e } from "vue";
import { createBlock as o } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as r } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as _ } from "vue";
import { ElMessageBox as Y } from "element-plus";
import { ElNotification as T } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElSwitch as P } from "element-plus";
import { vLoading as $ } from "element-plus";
import { l as m, D as b, g8 as H, x as M, o as G, aS as p, G as O, an as Q, P as j, ba as z } from "../../../../../shared/runtime.js";
import { p as D } from "../../../../../modules/contract-9b18cc88.js";
import I from "./module/form.vue.js";
import J from "./module/header.vue.js";
function K(s) {
  return m({ module: "contract", url: "contract/equipment-depreciation/page", method: "get", params: s });
}
function W(s) {
  return m({ module: "contract", url: "contract/equipment-depreciation", method: "post", data: s });
}
function X(s) {
  return m({ module: "contract", url: "contract/equipment-depreciation", method: "put", data: s });
}
function Z(s) {
  return m({ module: "contract", url: `contract/equipment-depreciation/${s}`, method: "delete" });
}
function ee({ id: s, boolStatus: f }) {
  return m({ module: "contract", url: "contract/equipment-depreciation/update-status", method: "put", params: { id: s, boolStatus: f } });
}
function te() {
  return m({ url: "/api/branchCompany/all/simple", method: "get" });
}
const ae = { get: K, add: W, edit: X, del: Z }, oe = { class: "app-container" }, ce = { __name: "index", setup(s) {
  const f = y([["startDate", ["parse-time", "{y}-{m}-{d}"]], ["endDate", ["parse-time", "{y}-{m}-{d}"]], ["yearDepreciationAmount", ["to-thousand", b.YUAN]], ["monthDepreciationAmount", ["to-thousand", b.YUAN]], ["originalValue", ["to-thousand", b.YUAN]]]), h = H(["equipment_depreciation_classification"]), x = { add: true, edit: false, del: false, download: false }, S = y(), g = y([]), { crud: d, columns: i } = M({ title: "设备折旧", sort: [], optShow: { ...x }, permission: { ...D }, crudApi: { ...ae }, hasPagination: true }, S);
  async function V(l, v) {
    try {
      await Y.confirm(`此操作将 ${l.equipmentName} 的状态改为 ${p.VL[v]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ee({ id: l.id, boolStatus: v }), d.toQuery(), T({ title: `${l.equipmentName}的状态修改成功`, type: "success", duration: 3e3 });
    } catch (t) {
      console.log("设备折旧状态变更失败", t), l.boolStatus = l.boolStatus === p.TRUE.V ? p.FALSE.V : p.TRUE.V;
    }
  }
  const { maxHeight: k } = G({ paginate: true });
  function A(l) {
    return z(l, { props: [["originalValue", b.YUAN]], toThousandFields: ["originalValue"] });
  }
  async function C() {
    try {
      const { content: l } = await te();
      g.value = l;
    } catch (l) {
      console.log(l);
    }
  }
  return C(), (l, v) => {
    const t = F, q = P, R = B("common-table"), E = $;
    return a(), L("div", oe, [c(J, { branchList: g.value }, null, 8, ["branchList"]), U((a(), o(R, { ref_key: "tableRef", ref: S, data: e(d).data, "data-format": f.value, "empty-text": e(d).emptyText, "max-height": e(k), onSelectionChange: e(d).selectionChangeHandler, "show-summary": "", "summary-method": A }, { default: u(() => [c(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(i).visible("name") ? (a(), o(t, { align: "center", key: "branchCompanyName", prop: "branchCompanyName", "show-overflow-tooltip": true, label: "费用归属", width: "180px" })) : r("", true), e(i).visible("classificationName") ? (a(), o(t, { align: "center", key: "classificationName", prop: "classificationName", "show-overflow-tooltip": true, label: "分类" }, { default: u(({ row: n }) => [w("span", null, _(e(h) && e(h).label && e(h).label.equipment_depreciation_classification ? e(h).label.equipment_depreciation_classification[n.classificationName] : "-"), 1)]), _: 1 })) : r("", true), e(i).visible("equipmentName") ? (a(), o(t, { align: "center", key: "equipmentName", prop: "equipmentName", "show-overflow-tooltip": true, label: "设备名称" })) : r("", true), e(i).visible("originalValue") ? (a(), o(t, { align: "center", key: "originalValue", prop: "originalValue", "show-overflow-tooltip": true, label: "原值（元）" })) : r("", true), e(i).visible("startDate") ? (a(), o(t, { align: "center", key: "startDate", prop: "startDate", "show-overflow-tooltip": true, label: "折旧起始日期" })) : r("", true), e(i).visible("depreciationYear") ? (a(), o(t, { align: "center", key: "depreciationYear", prop: "depreciationYear", "show-overflow-tooltip": true, label: "折旧年限" })) : r("", true), e(i).visible("yearDepreciationRate") ? (a(), o(t, { align: "center", key: "yearDepreciationRate", prop: "yearDepreciationRate", "show-overflow-tooltip": true, label: "年折旧率" }, { default: u(({ row: n }) => [w("span", null, _((n.yearDepreciationRate * 100).toFixed(2)) + " %", 1)]), _: 1 })) : r("", true), e(i).visible("yearDepreciationAmount") ? (a(), o(t, { align: "center", key: "yearDepreciationAmount", prop: "yearDepreciationAmount", "show-overflow-tooltip": true, label: "年折旧额" })) : r("", true), e(i).visible("monthDepreciationRate") ? (a(), o(t, { align: "center", key: "monthDepreciationRate", prop: "monthDepreciationRate", "show-overflow-tooltip": true, label: "月折旧率" }, { default: u(({ row: n }) => [w("span", null, _((n.monthDepreciationRate * 100).toFixed(2)) + " %", 1)]), _: 1 })) : r("", true), e(i).visible("monthDepreciationAmount") ? (a(), o(t, { align: "center", key: "monthDepreciationAmount", prop: "monthDepreciationAmount", "show-overflow-tooltip": true, label: "月折旧额" })) : r("", true), e(i).visible("remainingYears") ? (a(), o(t, { align: "center", key: "remainingYears", prop: "remainingYears", "show-overflow-tooltip": true, label: "剩余年限" })) : r("", true), e(i).visible("userName") ? (a(), o(t, { align: "center", key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "创建人" })) : r("", true), e(i).visible("boolStatus") ? (a(), o(t, { align: "center", key: "boolStatus", prop: "boolStatus", "show-overflow-tooltip": true, label: "状态" }, { default: u(({ row: n }) => [c(q, { modelValue: n.boolStatus, "onUpdate:modelValue": (N) => n.boolStatus = N, "active-value": e(p).TRUE.V, "inactive-value": e(p).FALSE.V, class: "drawer-switch", disabled: !e(O)(e(D).changeStatus) || !n.boolStatus, onChange: (N) => V(n, n.boolStatus) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 })) : r("", true), c(t, { align: "center", label: "操作", width: "140" }, { default: u(({ row: n }) => [c(e(Q), { data: n, permission: e(D) }, null, 8, ["data", "permission"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSelectionChange"])), [[E, e(d).loading]]), c(e(j)), c(I, { branchList: g.value }, null, 8, ["branchList"])]);
  };
} };
export {
  ce as default
};
