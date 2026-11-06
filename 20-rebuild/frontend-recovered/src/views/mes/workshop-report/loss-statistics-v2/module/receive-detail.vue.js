import { ref as f } from "vue";
import { inject as H } from "vue";
import { computed as L } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as A } from "vue";
import { createBlock as z } from "vue";
import { withCtx as a } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as n } from "vue";
import { unref as d } from "vue";
import { createElementVNode as c } from "vue";
import { isRef as F } from "vue";
import { ElTag as I } from "element-plus";
import { e as M } from "../../../../../modules/loss-statistics-v2-49b9ac9b.js";
import { _ as P, o as W, u as $, z as G, bv as J, am as R, p as K, cO as C, jl as N } from "../../../../../shared/runtime.js";
const Q = { class: "print-table" }, X = { __name: "receive-detail", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object }, partType: { type: Number } }, emits: ["update:visible"], setup(p, { emit: T }) {
  const D = T, _ = p, g = f(false), k = f([]), x = f(), S = f(0), B = f(0), w = H("query"), y = L(() => {
    var u, l;
    return { ...w, basicClass: _.partType || void 0, projectId: ((l = (u = _.currentRow) == null ? void 0 : u.project) == null ? void 0 : l.id) || void 0 };
  }), { maxHeight: U } = W({ mainBox: ".loss-statistics-v2-feeding-details", extraBox: [".el-drawer__header", ".print-table"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, () => x.value.loaded), { visible: b, handleClose: j } = $({ emit: D, props: _, field: "visible", showHook: V });
  async function O() {
    let u = [], l = [], o = [];
    g.value = true;
    try {
      w.workShopId && (y.value.workShopIds = [w.workShopId]);
      const { plantOutboundDetailList: s = [], plantReturnDetailList: t = [] } = await M({ ...y.value });
      s.length > 0 ? (await C(s), l = await N(s, { unit: l.accountingUnit, fields: ["mete"] }), l.forEach((r) => {
        r.contractAmount = "出库";
      })) : S.value = 0, t.length > 0 ? (await C(t), o = await N(t, { unit: t.accountingUnit, fields: ["mete"] }), o.forEach((r) => {
        r.contractAmount = "退库", r.mete = -r.mete, r.isPlantReturn = true;
      })) : B.value = 0, u = [...l, ...o];
    } catch (s) {
      console.error(s);
    } finally {
      k.value = u, g.value = false;
    }
  }
  function V() {
    O();
  }
  function E({ columns: u, data: l }) {
    const o = [];
    return u.forEach((s, t) => {
      if (t === 0) {
        o[t] = "合计";
        return;
      }
      if (["quantity", "mete"].includes(s.property)) {
        let r = 0;
        l.forEach((v) => {
          r += Number(v[s.property]) || 0;
        }), s.property === "mete" ? o[t] = r.toFixed(3) : o[t] = r.toString();
      } else o[t] = "";
    }), [o];
  }
  function q({ row: u }) {
    return u.isPlantReturn ? "vxe-row-red" : "";
  }
  return (u, l) => {
    const o = I, s = m("print-table"), t = m("vxe-column"), r = m("vxe-table"), v = m("common-drawer");
    return A(), z(v, { ref_key: "drawerRef", ref: x, title: `${d(R).VL[p.partType]}领用明细表`, modelValue: d(b), "onUpdate:modelValue": l[0] || (l[0] = (e) => F(b) ? b.value = e : null), "before-close": d(j), "custom-class": "loss-statistics-v2-feeding-details", size: "70%" }, { titleAfter: a(() => [i(o, { class: "filter-item" }, { default: a(() => {
      var e;
      return [h(" 项目：" + n(d(G)((e = p.currentRow) == null ? void 0 : e.project) || "-"), 1)];
    }), _: 1 }), i(o, { class: "filter-item" }, { default: a(() => {
      var e;
      return [h(" 排产总量（kg）：" + n(((e = p.currentRow) == null ? void 0 : e.schedulingWeight) ?? "-"), 1)];
    }), _: 1 })]), content: a(() => [c("div", Q, [i(s, { "api-key": "lossStatisticsReceiveDetail", params: y.value, type: "warning", class: "filter-item" }, null, 8, ["params"])]), i(r, { border: "", "show-header-overflow": "", "show-footer-overflow": "", "show-footer": "", stripe: "", ref: "tableRef", data: k.value, "max-height": d(U), loading: g.value, "loading-config": { text: "正在加载" }, "empty-text": "暂无数据", "column-config": { resizable: true }, "row-config": { isHover: true }, "return-source-data": "", "scroll-y": { enabled: true, scrollToTopOnChange: true, gt: 0 }, "scroll-x": { enabled: true, scrollToLeftOnChange: true, gt: 0 }, "show-overflow": "tooltip", "footer-method": E, "row-class-name": q }, { default: a(() => [i(t, { type: "seq", title: "序号", align: "center", width: "60", fixed: "left" }), i(t, { title: "类型", field: "contractAmount", key: "contractAmount", align: "center" }, { default: a((e) => [h(n(e.row.contractAmount || "-"), 1)]), _: 1 }), i(t, { title: "物料种类", field: "basicClass", key: "basicClass", align: "center" }, { default: a((e) => [c("span", null, n(e.row.basicClass ? d(J).getBits(d(R).ENUM, e.row.basicClass, "L").join("|") : ""), 1)]), _: 1 }), i(t, { title: "规格", field: "specification", key: "specification", align: "center" }, { default: a((e) => [c("span", null, n(e.row.specification || "-"), 1)]), _: 1 }), i(t, { title: "计量单位", field: "measureUnit", key: "measureUnit", align: "center" }, { default: a((e) => [c("span", null, n(e.row.measureUnit || "-"), 1)]), _: 1 }), i(t, { title: "数量", field: "quantity", key: "quantity", align: "center" }, { default: a((e) => [c("span", null, n(e.row.quantity ?? "-"), 1)]), _: 1 }), i(t, { title: "核算单位", field: "accountingUnit", key: "accountingUnit", align: "center" }, { default: a((e) => [c("span", null, n(e.row.accountingUnit ?? "-"), 1)]), _: 1 }), i(t, { title: "核算量", field: "mete", key: "mete", align: "center" }, { default: a((e) => [c("span", null, n(e.row.mete ?? "-"), 1)]), _: 1 }), i(t, { title: "出（退）库日期", field: "createTime", key: "createTime", align: "center", "min-width": "120" }, { default: a((e) => [c("span", null, n(e.row.createTime ? d(K)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), i(t, { title: "领用车间", field: "workShop", key: "workShop", align: "center" }, { default: a((e) => [c("span", null, n(e.row.workShop || "-"), 1)]), _: 1 }), i(t, { title: "领料人", field: "recipientName", key: "recipientName", align: "center" }, { default: a((e) => [c("span", null, n(e.row.recipientName || "-"), 1)]), _: 1 }), i(t, { title: "办理人", field: "applicantName", key: "applicantName", align: "center" }, { default: a((e) => [c("span", null, n(e.row.applicantName || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "loading"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, te = P(X, [["__scopeId", "data-v-9fbd0e48"]]);
export {
  te as default
};
