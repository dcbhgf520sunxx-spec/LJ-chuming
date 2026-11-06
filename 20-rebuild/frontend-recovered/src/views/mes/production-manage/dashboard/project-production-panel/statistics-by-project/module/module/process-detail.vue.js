import { ref as _ } from "vue";
import { computed as p } from "vue";
import { watch as O } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as n } from "vue";
import { createBlock as c } from "vue";
import { withCtx as r } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as x } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as w } from "vue";
import { unref as i } from "vue";
import { createElementVNode as V } from "vue";
import { normalizeStyle as G } from "vue";
import { isRef as M } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { i as K } from "../../../../../../../../modules/project-production-panel-fb6946a2.js";
import { _ as $, pJ as h, bv as F, pM as q, u as W, o as X, G as Y, pI as Z, i as P } from "../../../../../../../../shared/runtime.js";
import ee from "./shipping-table.vue.js";
import oe from "./reported-detail.vue.js";
import te from "./inspection-table.vue.js";
const ae = { __name: "process-detail", props: { visible: { type: Boolean, default: false }, processInfo: { type: Object, default: () => ({}) } }, emits: ["update:visible"], setup(T, { emit: B }) {
  const g = _(), E = B, l = T, v = p(() => {
    var e;
    return ((e = l.processInfo) == null ? void 0 : e.processType) === h.INSPECTION.V;
  }), k = p(() => {
    var e, o;
    return ((e = l.processInfo) == null ? void 0 : e.processType) === h.SHIPPING.V && ((o = l.processInfo) == null ? void 0 : o.processName) === "发运";
  }), u = p(() => {
    var e, o;
    return ((e = l.processInfo) == null ? void 0 : e.processType) === h.REPORT.V && ((o = l.processInfo) == null ? void 0 : o.processName) !== "零件";
  });
  function Q({ row: e, rowIndex: o }) {
    return P(e.boolCompleted) ? e.boolCompleted ? "completed" : "unfinished" : "";
  }
  function R({ row: e, rowIndex: o }) {
    return P(e.boolCompleted) ? e.boolCompleted ? "completed" : "unfinished" : "";
  }
  const L = p(() => {
    var e;
    return ((e = F.toArr(q).find((o) => o.V === l.processInfo.productType)) == null ? void 0 : e.L) || "";
  }), { visible: d, handleClose: S } = W({ emit: E, props: l, field: "visible" }), { maxHeight: D } = X({ extraBox: [".el-drawer__header"], extraHeight: 10, wrapperBox: [".el-drawer__body"] }, g);
  O(() => l.visible, (e) => {
    e && j();
  }, { immediate: true });
  const f = _(false), N = _([]);
  async function j() {
    if (!Y(Z.detailGouJian)) return;
    let e = [];
    try {
      f.value = true;
      const { ...o } = l.processInfo;
      delete o.productKanBanCompanyStatusEnum, delete o.totalReportQuantity, delete o.totalTaskQuantity, e = await K(o) || [];
    } catch (o) {
      console.log("获取零件生产状态", o);
    } finally {
      N.value = e, f.value = false;
    }
  }
  return (e, o) => {
    const y = U, s = J, z = b("table-cell-tag"), A = b("common-table"), H = b("common-drawer");
    return n(), c(H, { ref_key: "drawerRef", ref: g, title: `${L.value}详情`, modelValue: i(d), "onUpdate:modelValue": o[0] || (o[0] = (t) => M(d) ? d.value = t : null), contentLoading: f.value, direction: "rtl", "before-close": i(S), size: "100%" }, { titleAfter: r(() => [u.value || v.value || k.value ? (n(), I(x, { key: 0 }, [a(y, { effect: "plain", size: "large" }, { default: r(() => {
      var t;
      return [C(" 工单号：" + m(((t = l.processInfo) == null ? void 0 : t.orderNumber) || "-"), 1)];
    }), _: 1 }), a(y, { effect: "plain", size: "large" }, { default: r(() => {
      var t;
      return [C(" 工序：" + m(((t = l.processInfo) == null ? void 0 : t.processName) || "-"), 1)];
    }), _: 1 })], 64)) : w("", true)]), content: r(() => [a(A, { data: N.value, "max-height": i(D), style: { width: "100%", "margin-top": "10px" }, "row-class-name": Q, "cell-class-name": R }, { default: r(() => [a(s, { label: "序号", type: "index", align: "center", width: "60" }), a(s, { key: "name", prop: "name", "show-overflow-tooltip": true, align: "center", label: "产品名称", "min-width": "140" }, { default: r(({ row: t }) => [t.boolAssist ? (n(), c(z, { key: 0, name: "协同", color: "#e64242", offset: 15 })) : w("", true), V("span", null, m(t.name || "-"), 1)]), _: 1 }), a(s, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "产品编号", "min-width": "140" }), a(s, { key: "specification", prop: "specification", "show-overflow-tooltip": true, align: "center", label: "规格", "min-width": "140" }), k.value ? (n(), c(i(ee), { key: 0 })) : u.value ? (n(), c(i(oe), { key: 1 })) : v.value ? (n(), c(i(te), { key: 2 })) : u.value ? w("", true) : (n(), I(x, { key: 3 }, [a(s, { key: "productionLineName", prop: "productionLineName", "show-overflow-tooltip": true, label: "生产线名称", align: "center", "min-width": "140" }), a(s, { key: "processName", align: "center", prop: "processName", "show-overflow-tooltip": true, label: "工序名称", "min-width": "140" }), a(s, { key: "teamUserName", align: "center", prop: "teamUserName", "show-overflow-tooltip": true, label: "班组长名称", "min-width": "140" }), a(s, { key: "orderNumber", align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "任务工单号", "min-width": "140" }), a(s, { key: "taskQuantity", align: "center", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数量", "min-width": "140" }), a(s, { key: "companyQuantity", align: "center", prop: "companyQuantity", "show-overflow-tooltip": true, label: "完成数量", "min-width": "140" }, { default: r(({ row: t }) => [V("span", { style: G({ color: t.companyQuantity >= t.taskQuantity ? "#00751f" : "#ff0f1a" }) }, m(t.companyQuantity), 5)]), _: 1 })], 64))]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["title", "modelValue", "contentLoading", "before-close"]);
  };
} }, pe = $(ae, [["__scopeId", "data-v-a773933e"]]);
export {
  pe as default
};
