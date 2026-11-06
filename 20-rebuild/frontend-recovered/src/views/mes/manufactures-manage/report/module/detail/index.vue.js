import { ref as f } from "vue";
import { inject as w } from "vue";
import { computed as g } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as y } from "vue";
import { createBlock as T } from "vue";
import { withCtx as x } from "vue";
import { withDirectives as L } from "vue";
import { createElementBlock as N } from "vue";
import { resolveDynamicComponent as q } from "vue";
import { unref as e } from "vue";
import { createVNode as A } from "vue";
import { isRef as O } from "vue";
import { ElPagination as P } from "element-plus";
import { vLoading as $ } from "element-plus";
import { a as M, b as U } from "../../../../../../modules/report-1b32adbc.js";
import { u as F, J, o as G, o8 as l } from "../../../../../../shared/runtime.js";
import K from "./structure.vue.js";
import Q from "./enclosure.vue.js";
const te = { __name: "index", props: { visible: { type: Boolean, default: false }, itemInfo: { type: Object, default: () => {
} }, reportType: { type: Number, default: void 0 }, isSummary: { type: Boolean, default: false } }, emits: ["update:visible"], setup(o, { emit: _ }) {
  const h = f(), I = _, r = o, { visible: u, handleClose: V } = F({ emit: I, props: r, field: "visible", showHook: C }), { handleSizeChange: E, handleCurrentChange: k, total: R, setTotalPage: S, queryPage: c } = J({ fetchHook: C }), { maxHeight: z } = G({ mainBox: ".mes-report-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, minHeight: 400, paginate: true, clientHRepMainH: true }, h), B = w("reportTypeEnum"), b = g(() => parseInt(r.itemInfo.productType) || m.productType), D = g(() => r.itemInfo.id || m.projectId), H = g(() => {
    switch (b.value) {
      case l.ARTIFACT.V:
        return K;
      case l.ENCLOSURE.V:
        return Q;
      default:
        return null;
    }
  }), m = w("query"), p = f(false), v = f([]);
  async function C() {
    try {
      p.value = true;
      const { startDate: n, endDate: t } = m, s = Object.assign({ startDate: n, endDate: t, projectId: D.value, type: r.reportType }, c);
      let a = [];
      switch (b.value) {
        case l.ARTIFACT.V:
          a = await U(s);
          break;
        case l.ENCLOSURE.V:
          a = await M(s);
          break;
        default:
          break;
      }
      S(a.totalElements), v.value = a.content.map((i, d) => (i.rowId = d + "" + Math.random(), i));
    } catch (n) {
      console.log("入发存详情", n);
    } finally {
      p.value = false;
    }
  }
  return (n, t) => {
    const s = P, a = j("common-drawer"), i = $;
    return y(), T(a, { ref_key: "drawerRef", ref: h, title: `入发存${e(B).VL[o.reportType]}报表${o.isSummary ? "" : "(" + o.itemInfo.shortName + ")"}`, modelValue: e(u), "onUpdate:modelValue": t[0] || (t[0] = (d) => O(u) ? u.value = d : null), direction: "rtl", "before-close": e(V), size: "100%", "custom-class": "mes-report-detail" }, { titleRight: x(() => t[1] || (t[1] = [])), content: x(() => [L((y(), N("div", null, [(y(), T(q(H.value), { "table-data": v.value, "max-height": e(z), "is-summary": o.isSummary }, null, 8, ["table-data", "max-height", "is-summary"])), A(s, { total: e(R), "current-page": e(c).pageNumber, "page-size": e(c).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(E), onCurrentChange: e(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])), [[i, p.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  te as default
};
