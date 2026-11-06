import { ref as u } from "vue";
import { provide as d } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as o } from "vue";
import { unref as g } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as G } from "vue";
import { withCtx as k } from "vue";
import { toDisplayString as M } from "vue";
import { h as q } from "vue";
import { nextTick as D } from "vue";
import { ElTableColumn as F } from "element-plus";
import { vLoading as V } from "element-plus";
import { _ as $, m as H, o as L, pF as z, G as A, pG as J } from "../../../../../shared/runtime.js";
import K from "./module/header.vue.js";
import O from "./module/detail.vue.js";
import { g as Q } from "../../../../../modules/project-material-c2039d20.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const U = { class: "app-container" }, X = { style: { display: "flex" } }, Y = { calss: "left-container" }, Z = { class: "head-container" }, ee = { __name: "index", setup(te) {
  const m = u(), x = u(), f = u(false), w = u([]), { globalProjectId: N } = H(["globalProjectId"]), h = u({}), { maxHeight: R } = L({ extraBox: [".head-container"], paginate: false }), C = async (e) => {
    if (A(J.get)) {
      f.value = true;
      try {
        const { content: l = [] } = await Q(e);
        w.value = l;
        await b();
        l.length ? W() : h.value = {};
      } finally {
        f.value = false;
      }
    }
  }, E = (e) => {
    h.value = e;
    v()?.classList.remove("current-row");
  }, W = () => {
    x.value?.setCurrentRow();
    h.value = { title: "合计" };
    v()?.classList.add("current-row");
  }, P = (e) => {
    const { columns: l, data: t } = e, r = [];
    return l.forEach((i, s) => {
      var v;
      if (s === 0) {
        r[s] = q("div", {}, "合计");
        return;
      }
      if (!["totalNetWeight", "receiveWeight", "wastageRate"].includes(i.property)) {
        r[s] = "";
        return;
      }
      const n = t.map((a) => Number(a[i.property]));
      if (n.every((a) => Number.isNaN(a))) {
        r[s] = "";
        return;
      }
      if (i.property === "wastageRate") {
        r[s] = `${(n.reduce((a, c) => {
          const _ = Number(c);
          return Number.isNaN(_) ? a : a + c;
        }, 0) / t.length).toFixed(2)}`;
        return;
      }
      r[s] = `${(v = n.reduce((a, c) => {
        const _ = Number(c);
        return Number.isNaN(_) ? a : a + c;
      }, 0)) == null ? void 0 : v.toFixed(2)}`;
    }), r;
  };
  d("projectId", N), d("currentRow", h), d("headerRef", m), d("tableInfo", { renderTable: C });
  function v() {
    return x.value?.$el?.querySelector(".el-table__footer-wrapper tr");
  }
  async function b() {
    await D();
    const e = v();
    e && (e.onclick = W, e.classList.remove("current-row"));
  }
  return (e, l) => {
    const t = F, r = B("common-table"), i = V;
    return y(), I("div", U, [p("div", X, [p("div", Y, [p("div", Z, [o(g(K), { ref_key: "headerRef", ref: m }, null, 512)]), j((y(), G(r, { ref_key: "tableRef", ref: x, data: w.value, "max-height": g(R), "highlight-current-row": "", "summary-method": P, "show-summary": "", "row-key": "totalGrossWeight", onRowClick: E, style: { width: "100%", cursor: "pointer" } }, { default: k(() => [o(t, { prop: "index", type: "index", label: "序号", align: "center", width: "60" }), o(t, { key: "productClassificationEnum", prop: "productClassificationEnum", align: "center", "show-overflow-tooltip": true, label: "类型" }, { default: k((s) => {
      var n;
      return [p("span", null, M((n = g(z).V[s.row.productClassificationEnum]) == null ? void 0 : n.SL), 1)];
    }), _: 1 }), o(t, { key: "steelSpec", prop: "steelSpec", align: "center", "show-overflow-tooltip": true, label: "规格(厚度)" }), o(t, { key: "material", prop: "material", align: "center", "show-overflow-tooltip": true, label: "材质" }), o(t, { key: "totalNetWeight", prop: "totalNetWeight", align: "center", width: "120", "show-overflow-tooltip": true, label: "清单总净重(kg)" }), o(t, { key: "receiveWeight", prop: "receiveWeight", align: "center", width: "120", "show-overflow-tooltip": true, label: "领料量(kg)" }), o(t, { key: "wastageRate", prop: "wastageRate", align: "center", "show-overflow-tooltip": true, label: "损耗率(%)" })]), _: 1 }, 8, ["data", "max-height"])), [[i, f.value]])]), l[0] || (l[0] = p("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), o(O, { style: { flex: "1" } })])]);
  };
} }, ce = $(ee, [["__scopeId", "data-v-022c92be"]]);
export {
  ce as default
};
