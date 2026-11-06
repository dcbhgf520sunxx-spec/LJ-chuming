import { ref as w } from "vue";
import { inject as B } from "vue";
import { computed as T } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as H } from "vue";
import { createBlock as O } from "vue";
import { withCtx as r } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as i } from "vue";
import { unref as u } from "vue";
import { createElementVNode as s } from "vue";
import { isRef as S } from "vue";
import { ElTag as L } from "element-plus";
import { b as P } from "../../../../../modules/loss-statistics-v2-49b9ac9b.js";
import { _ as z, o as F, sq as v, u as M, z as U, p as A } from "../../../../../shared/runtime.js";
const $ = { class: "print-table" }, G = { __name: "work-report-details", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object }, partType: { type: Number } }, emits: ["update:visible"], setup(m, { emit: R }) {
  const N = R, c = m, _ = w(false), h = w([]), b = w(), V = B("query"), k = T(() => {
    var l, a;
    return { ...V, partType: c.partType, projectId: ((a = (l = c.currentRow) == null ? void 0 : l.project) == null ? void 0 : a.id) || void 0 };
  }), { maxHeight: W } = F({ mainBox: ".loss-statistics-v2-work-report-details", extraBox: [".el-drawer__header", ".print-table"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, () => b.value.loaded), C = T(() => {
    var l, a;
    return c.partType === v.STEEL_PLATE_PRODUCT.V ? (l = c.currentRow) == null ? void 0 : l.steelReportWeight : c.partType === v.SECTION_PRODUCT.V ? (a = c.currentRow) == null ? void 0 : a.profilesReportWeight : void 0;
  }), { visible: g, handleClose: D } = M({ emit: N, props: c, field: "visible", showHook: E });
  async function q() {
    let l = [];
    _.value = true;
    try {
      l = await P(k.value) || [];
    } catch (a) {
      console.log(a);
    } finally {
      h.value = l, _.value = false;
    }
  }
  function E() {
    q();
  }
  function j({ columns: l, data: a }) {
    const n = [];
    return l.forEach((d, t) => {
      if (t === 0) {
        n[t] = "合计";
        return;
      }
      if (["quantity", "totalWeight"].includes(d.property)) {
        let p = 0;
        a.forEach((y) => {
          p += Number(y[d.property]) || 0;
        }), d.property === "totalWeight" ? n[t] = p.toFixed(3) : n[t] = p.toString();
      } else n[t] = "";
    }), [n];
  }
  return (l, a) => {
    const n = L, d = f("print-table"), t = f("vxe-column"), p = f("vxe-table"), y = f("common-drawer");
    return H(), O(y, { ref_key: "drawerRef", ref: b, title: `${u(v).VL[m.partType]}报工明细表`, modelValue: u(g), "onUpdate:modelValue": a[0] || (a[0] = (e) => S(g) ? g.value = e : null), "before-close": u(D), "custom-class": "loss-statistics-v2-work-report-details", size: "50%" }, { titleAfter: r(() => [o(n, { class: "filter-item" }, { default: r(() => {
      var e;
      return [x(" 项目：" + i(u(U)((e = m.currentRow) == null ? void 0 : e.project) || "-"), 1)];
    }), _: 1 }), o(n, { class: "filter-item" }, { default: r(() => [x(" 报工总量（kg）： " + i(C.value ?? "-"), 1)]), _: 1 })]), content: r(() => [s("div", $, [o(d, { "api-key": "lossStatisticsPartReportDetail", params: k.value, type: "warning", class: "filter-item" }, null, 8, ["params"])]), o(p, { border: "", "show-header-overflow": "", "show-footer-overflow": "", "show-footer": "", stripe: "", ref: "tableRef", data: h.value, "max-height": u(W), loading: _.value, "loading-config": { text: "正在加载" }, "empty-text": "暂无数据", "column-config": { resizable: true }, "row-config": { isHover: true }, "return-source-data": "", "scroll-y": { enabled: true, scrollToTopOnChange: true, gt: 0 }, "scroll-x": { enabled: true, scrollToLeftOnChange: true, gt: 0 }, "show-overflow": "tooltip", "footer-method": j }, { default: r(() => [o(t, { type: "seq", title: "序号", align: "center", width: "60", fixed: "left" }), o(t, { title: "报工日期", field: "createTime", key: "createTime", align: "center" }, { default: r((e) => [s("div", null, i(e.row.createTime ? u(A)(e.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), o(t, { title: "报工人", field: "reportName", key: "reportName", align: "center" }, { default: r((e) => [s("div", null, i(e.row.reportName || "-"), 1)]), _: 1 }), o(t, { title: "单体", field: "monomerName", key: "monomerName", align: "center" }, { default: r((e) => [s("div", null, i(e.row.monomerName || "-"), 1)]), _: 1 }), o(t, { title: "编号", field: "serialNumber", key: "serialNumber", align: "center" }, { default: r((e) => [s("div", null, i(e.row.serialNumber || "-"), 1)]), _: 1 }), o(t, { title: "规格", field: "specification", key: "specification", align: "center" }, { default: r((e) => [s("div", null, i(e.row.specification || "-"), 1)]), _: 1 }), o(t, { title: "数量", field: "quantity", key: "quantity", align: "center" }, { default: r((e) => [s("div", null, i(e.row.quantity ?? "-"), 1)]), _: 1 }), o(t, { title: "单重（kg）", field: "netWeight", key: "netWeight", align: "center" }, { default: r((e) => [s("div", null, i(e.row.netWeight ?? "-"), 1)]), _: 1 }), o(t, { title: "总重（kg）", field: "totalWeight", key: "totalWeight", align: "center" }, { default: r((e) => [s("div", null, i(e.row.totalWeight ?? "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "loading"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Q = z(G, [["__scopeId", "data-v-5223c891"]]);
export {
  Q as default
};
