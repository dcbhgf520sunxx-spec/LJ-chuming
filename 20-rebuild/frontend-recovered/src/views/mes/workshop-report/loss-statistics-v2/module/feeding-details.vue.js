import { ref as y } from "vue";
import { inject as W } from "vue";
import { computed as C } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as w } from "vue";
import { createBlock as E } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as o } from "vue";
import { unref as c } from "vue";
import { createElementVNode as r } from "vue";
import { createElementBlock as T } from "vue";
import { isRef as N } from "vue";
import { ElTag as F } from "element-plus";
import { d as L } from "../../../../../modules/loss-statistics-v2-49b9ac9b.js";
import { _ as U, o as z, u as M, z as O, o3 as A, sq as G, p as J } from "../../../../../shared/runtime.js";
const K = { class: "print-table" }, P = { key: 0 }, Q = { key: 1 }, X = { __name: "feeding-details", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object }, partType: { type: Number } }, emits: ["update:visible"], setup(p, { emit: V }) {
  const R = V, h = p, g = y(false), v = y([]), b = y(), q = W("query"), x = C(() => {
    var s, i;
    return { ...q, projectId: ((i = (s = h.currentRow) == null ? void 0 : s.project) == null ? void 0 : i.id) || void 0 };
  }), { maxHeight: B } = z({ mainBox: ".loss-statistics-v2-feeding-details", extraBox: [".el-drawer__header", ".print-table"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, () => b.value.loaded), { visible: m, handleClose: j } = M({ emit: R, props: h, field: "visible", showHook: H });
  async function D() {
    let s = [];
    g.value = true;
    try {
      s = await L(x.value) || [];
    } catch (i) {
      console.log(i);
    } finally {
      v.value = s, g.value = false;
    }
  }
  function H() {
    D();
  }
  function S({ columns: s, data: i }) {
    const n = [];
    return s.forEach((f, t) => {
      if (t === 0) {
        n[t] = "合计";
        return;
      }
      if (["quantity", "totalWeight"].includes(f.property)) {
        let d = 0;
        i.forEach((_) => {
          d += Number(_[f.property]) || 0;
        }), f.property === "totalWeight" ? n[t] = d.toFixed(3) : n[t] = d.toString();
      } else n[t] = "";
    }), [n];
  }
  return (s, i) => {
    const n = F, f = u("print-table"), t = u("vxe-column"), d = u("vxe-table"), _ = u("common-drawer");
    return w(), E(_, { ref_key: "drawerRef", ref: b, title: "投料明细表", modelValue: c(m), "onUpdate:modelValue": i[0] || (i[0] = (e) => N(m) ? m.value = e : null), "before-close": c(j), "custom-class": "loss-statistics-v2-feeding-details", size: "50%" }, { titleAfter: a(() => [l(n, { class: "filter-item" }, { default: a(() => {
      var e;
      return [k(" 项目：" + o(c(O)((e = p.currentRow) == null ? void 0 : e.project) || "-"), 1)];
    }), _: 1 }), l(n, { class: "filter-item" }, { default: a(() => {
      var e;
      return [k(" 排产总量（kg）：" + o(((e = p.currentRow) == null ? void 0 : e.schedulingWeight) ?? "-"), 1)];
    }), _: 1 })]), content: a(() => [r("div", K, [l(f, { "api-key": "lossStatisticsSteelFeedingDetail", params: x.value, type: "warning", class: "filter-item" }, null, 8, ["params"])]), l(d, { border: "", "show-header-overflow": "", "show-footer-overflow": "", "show-footer": "", stripe: "", ref: "tableRef", data: v.value, "max-height": c(B), loading: g.value, "loading-config": { text: "正在加载" }, "empty-text": "暂无数据", "column-config": { resizable: true }, "row-config": { isHover: true }, "return-source-data": "", "scroll-y": { enabled: true, scrollToTopOnChange: true, gt: 0 }, "scroll-x": { enabled: true, scrollToLeftOnChange: true, gt: 0 }, "show-overflow": "tooltip", "footer-method": S }, { default: a(() => [l(t, { type: "seq", title: "序号", align: "center", width: "60", fixed: "left" }), l(t, { title: "类型", field: "type", key: "type", align: "center" }, { default: a((e) => [e.row.type ? (w(), T("span", P, o(c(A).VL[e.row.type]), 1)) : (w(), T("span", Q, "-"))]), _: 1 }), l(t, { title: "材料类型", field: "stuffType", key: "stuffType", align: "center" }, { default: a((e) => [r("span", null, o(e.row.stuffType ? c(G).VL[e.row.stuffType] : "-"), 1)]), _: 1 }), l(t, { title: "规格", field: "specification", key: "specification", align: "center" }, { default: a((e) => [r("span", null, o(e.row.specification || "-"), 1)]), _: 1 }), l(t, { title: "材质", field: "material", key: "material", align: "center" }, { default: a((e) => [r("span", null, o(e.row.material || "-"), 1)]), _: 1 }), l(t, { title: "数量", field: "quantity", key: "quantity", align: "center" }, { default: a((e) => [r("span", null, o(e.row.quantity ?? "-"), 1)]), _: 1 }), l(t, { title: "重量", field: "totalWeight", key: "totalWeight", align: "center" }, { default: a((e) => [r("span", null, o(e.row.totalWeight ?? "-"), 1)]), _: 1 }), l(t, { title: "投（退）料日期", field: "feedingTime", key: "feedingTime", align: "center", "min-width": "120" }, { default: a((e) => [r("span", null, o(e.row.feedingTime ? c(J)(e.row.feedingTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), l(t, { title: "投料人", field: "feedingUser", key: "feedingUser", align: "center" }, { default: a((e) => [r("span", null, o(e.row.feedingUser || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "loading"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, I = U(X, [["__scopeId", "data-v-41e29135"]]);
export {
  I as default
};
