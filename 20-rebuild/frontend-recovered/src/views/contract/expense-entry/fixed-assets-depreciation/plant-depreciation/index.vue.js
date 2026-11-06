import { ref as y } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as L } from "vue";
import { unref as e } from "vue";
import { createBlock as o } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as x } from "vue";
import { ElMessageBox as U } from "element-plus";
import { ElNotification as Y } from "element-plus";
import { ElTableColumn as T } from "element-plus";
import { ElSwitch as P } from "element-plus";
import { vLoading as $ } from "element-plus";
import { l as p, x as M, o as q, D as b, aS as u, G as H, an as G, P as O, ba as Q } from "../../../../../shared/runtime.js";
import { q as w } from "../../../../../modules/contract-9b18cc88.js";
import j from "./module/form.vue.js";
import z from "./module/header.vue.js";
function I(s) {
  return p({ module: "contract", url: "contract/fixed-assets-depreciation/factory-building-depreciation/page", method: "get", params: s });
}
function J(s) {
  return p({ module: "contract", url: "contract/fixed-assets-depreciation/factory-building-depreciation", method: "post", data: s });
}
function K(s) {
  return p({ module: "contract", url: "contract/fixed-assets-depreciation/factory-building-depreciation", method: "put", data: s });
}
function W(s) {
  return p({ module: "contract", url: `contract/fixed-assets-depreciation/factory-building-depreciation/${s}`, method: "delete" });
}
function X({ id: s, boolStatus: g }) {
  return p({ module: "contract", url: "contract/fixed-assets-depreciation/factory-building-depreciation/update-status", method: "put", params: { id: s, boolStatus: g } });
}
function Z() {
  return p({ url: "/api/branchCompany/all/simple", method: "get" });
}
const ee = { get: I, add: J, edit: K, del: W }, te = { class: "app-container" }, ae = { class: "header-container" }, se = { __name: "index", setup(s) {
  const g = { add: true, edit: false, del: false, download: false }, _ = y(), f = y([]), { crud: m, columns: i } = M({ title: "厂房折旧", sort: [], optShow: { ...g }, permission: { ...w }, crudApi: { ...ee }, hasPagination: true }, _);
  async function S(r, h) {
    console.log(r, h);
    try {
      await U.confirm(`此操作将 ${r.name} 的状态改为 ${u.VL[h]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await X({ id: r.id, boolStatus: h }), m.toQuery(), Y({ title: `${r.name}的状态修改成功`, type: "success", duration: 3e3 });
    } catch (t) {
      console.log("变更是否固定资产折旧失败", t), r.boolStatus = r.boolStatus === u.TRUE.V ? u.FALSE.V : u.TRUE.V;
    }
  }
  const { maxHeight: k } = q({ paginate: true }), A = y([["startDate", ["parse-time", "{y}-{m}-{d}"]], ["yearDepreciationAmount", ["to-thousand", b.YUAN]], ["monthDepreciationAmount", ["to-thousand", b.YUAN]], ["originalValue", ["to-thousand", b.YUAN]]]);
  async function V() {
    try {
      const { content: r } = await Z();
      f.value = r;
    } catch (r) {
      console.log(r);
    }
  }
  V();
  function N(r) {
    return Q(r, { props: [["originalValue", b.YUAN]], toThousandFields: ["originalValue"] });
  }
  return (r, h) => {
    const t = T, R = P, C = B("common-table"), E = $;
    return a(), F("div", te, [v("div", ae, [c(z, { branchList: f.value }, null, 8, ["branchList"])]), L((a(), o(C, { ref_key: "tableRef", ref: _, data: e(m).data, "empty-text": e(m).emptyText, "max-height": e(k), "data-format": A.value, "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": N }, { default: d(() => [c(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(i).visible("branchCompanyName") ? (a(), o(t, { align: "center", key: "branchCompanyName", prop: "branchCompanyName", "show-overflow-tooltip": true, label: "费用归属", width: "180px" })) : l("", true), e(i).visible("name") ? (a(), o(t, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" })) : l("", true), e(i).visible("grossFloorArea") ? (a(), o(t, { align: "center", key: "grossFloorArea", prop: "grossFloorArea", "show-overflow-tooltip": true, label: "建筑面积" })) : l("", true), e(i).visible("originalValue") ? (a(), o(t, { align: "center", key: "originalValue", prop: "originalValue", "show-overflow-tooltip": true, label: "原值（元）" })) : l("", true), e(i).visible("startDate") ? (a(), o(t, { align: "center", key: "startDate", prop: "startDate", "show-overflow-tooltip": true, label: "折旧起始日期" })) : l("", true), e(i).visible("depreciationYear") ? (a(), o(t, { align: "center", key: "depreciationYear", prop: "depreciationYear", "show-overflow-tooltip": true, label: "折旧年限" })) : l("", true), e(i).visible("yearDepreciationRate") ? (a(), o(t, { align: "center", key: "yearDepreciationRate", prop: "yearDepreciationRate", "show-overflow-tooltip": true, label: "年折旧率" }, { default: d(({ row: n }) => [v("span", null, x((n.yearDepreciationRate * 100).toFixed(2)) + " %", 1)]), _: 1 })) : l("", true), e(i).visible("yearDepreciationAmount") ? (a(), o(t, { align: "center", key: "yearDepreciationAmount", prop: "yearDepreciationAmount", "show-overflow-tooltip": true, label: "年平均折旧金额" })) : l("", true), e(i).visible("monthDepreciationRate") ? (a(), o(t, { align: "center", key: "monthDepreciationRate", prop: "monthDepreciationRate", "show-overflow-tooltip": true, label: "月折旧率" }, { default: d(({ row: n }) => [v("span", null, x((n.monthDepreciationRate * 100).toFixed(2)) + " %", 1)]), _: 1 })) : l("", true), e(i).visible("monthDepreciationAmount") ? (a(), o(t, { align: "center", key: "monthDepreciationAmount", prop: "monthDepreciationAmount", "show-overflow-tooltip": true, label: "月平均折旧金额" })) : l("", true), e(i).visible("remainingYears") ? (a(), o(t, { align: "center", key: "remainingYears", prop: "remainingYears", "show-overflow-tooltip": true, label: "剩余年限" })) : l("", true), e(i).visible("userName") ? (a(), o(t, { align: "center", key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "创建人" })) : l("", true), e(i).visible("boolStatus") ? (a(), o(t, { align: "center", key: "boolStatus", prop: "boolStatus", "show-overflow-tooltip": true, label: "状态" }, { default: d(({ row: n }) => [c(R, { modelValue: n.boolStatus, "onUpdate:modelValue": (D) => n.boolStatus = D, "active-value": e(u).TRUE.V, "inactive-value": e(u).FALSE.V, class: "drawer-switch", disabled: !e(H)(e(w).changeStatus) || !n.boolStatus, onChange: (D) => S(n, n.boolStatus) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 })) : l("", true), c(t, { align: "center", label: "操作", width: "120px" }, { default: d((n) => [c(e(G), { data: n.row, disabledEdit: !n.row.boolStatus, disabledDel: !n.row.boolStatus, permission: e(w) }, null, 8, ["data", "disabledEdit", "disabledDel", "permission"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[E, e(m).loading]]), c(e(O)), c(j, { branchList: f.value }, null, 8, ["branchList"])]);
  };
} };
export {
  se as default
};
