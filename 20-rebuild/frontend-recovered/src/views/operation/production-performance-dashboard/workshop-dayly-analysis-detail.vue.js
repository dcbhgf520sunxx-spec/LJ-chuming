import { ref as v } from "vue";
import { watch as R } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as h } from "vue";
import { createBlock as x } from "vue";
import { withCtx as a } from "vue";
import { createVNode as m } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as c } from "vue";
import { unref as f } from "vue";
import { createCommentVNode as z } from "vue";
import { createElementVNode as g } from "vue";
import { createElementBlock as I } from "vue";
import { isRef as H } from "vue";
import { ElTag as S } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { dS as E, u as O, G as D, i as G, o as L, p as U, L as W, c as A } from "../../../shared/runtime.js";
import { n as F, o as P } from "../../../modules/production-performance-dashboard-bb1cff92.js";
const Y = { key: 0 }, $ = { key: 1 }, X = { __name: "workshop-dayly-analysis-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object }, workshopId: { type: Number }, searchDate: { type: [Number, String] }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: B }) {
  const { workshops: N } = E(), b = v([]), w = v(""), V = B, i = s, { visible: p, handleClose: M } = O({ emit: V, props: i, field: "visible", showHook: j });
  R(() => i.visible, (t) => {
    var o, n;
    t && (w.value = (n = (o = N.value) == null ? void 0 : o.find((r) => r.id === i.workshopId)) == null ? void 0 : n.name);
  }, { immediate: true });
  async function j() {
    var o;
    if (!D((o = i.permission) == null ? void 0 : o.detail)) return false;
    let t = [];
    if (i.searchDate) try {
      if (t = await F({ isMonthly: 0, ...i.query, workshopId: i.workshopId, yearDate: i.searchDate }) || [], (t == null ? void 0 : t.length) > 0) {
        const r = t == null ? void 0 : t.reduce((u, d) => G(d == null ? void 0 : d.mete) ? u + (d == null ? void 0 : d.mete) : u, 0);
        t.push({ type: 2, id: "total_" + Math.random(), index: "合计", dateTime: "", mete: r, ratio: "" });
      }
    } catch (n) {
      console.log("获取车间日详情失败", n);
    } finally {
      b.value = t;
    }
  }
  const { maxHeight: T } = L({ mainBox: ".dayly-anlysis-detail-class", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: false, navbar: false }, p);
  function C({ row: t, rowIndex: o }) {
    if (t.index === "合计") return { position: "sticky", bottom: "0 !important", zIndex: 1 };
  }
  return (t, o) => {
    const n = S, r = q, u = _("common-table"), d = _("common-drawer");
    return h(), x(d, { "custom-class": "dayly-anlysis-detail-class", ref: "drawerRef", title: "车间日产量详情", modelValue: f(p), "onUpdate:modelValue": o[0] || (o[0] = (e) => H(p) ? p.value = e : null), direction: "rtl", "before-close": f(M), size: "50%" }, { titleAfter: a(() => [m(n, { type: "danger", size: "default" }, { default: a(() => {
      var e, l;
      return [y(" 二级单位： " + c((e = s.branchInfo) != null && e.name ? (l = s.branchInfo) == null ? void 0 : l.name : "全部分支机构"), 1)];
    }), _: 1 }), m(n, { size: "default" }, { default: a(() => [y(" 车间： " + c(w.value ? w.value : "全部车间"), 1)]), _: 1 }), m(n, { type: "success", size: "default" }, { default: a(() => [y(" 日期： " + c(s.searchDate ? f(U)(s.searchDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), titleRight: a(() => {
      var e, l;
      return [f(D)((e = s.permission) == null ? void 0 : e.download) ? (h(), x(W, { key: 0, fn: f(P), params: { isMonthly: 0, ...s.query, workshopId: s.workshopId, yearDate: s.searchDate }, disabled: !((l = b.value) != null && l.length) }, { default: a(() => o[1] || (o[1] = [y(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : z("", true)];
    }), content: a(() => [m(u, { ref: "tableRef", data: b.value, "row-style": C, "max-height": f(T), style: { width: "100%" } }, { default: a(() => [m(r, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "80", type: "index" }, { default: a(({ row: e, $index: l }) => [g("span", null, c(e != null && e.type && e.type === 2 ? "合计" : l + 1), 1)]), _: 1 }), m(r, { "show-overflow-tooltip": true, prop: "dateTime", label: "项目", "header-align": "center", align: "left", "min-width": "120" }, { default: a(({ row: e }) => {
      var l, k;
      return [g("span", null, c(e.projectInfo ? ((l = e.projectInfo) == null ? void 0 : l.serialNumber) + "-" + ((k = e.projectInfo) == null ? void 0 : k.name) : ""), 1)];
    }), _: 1 }), m(r, { "show-overflow-tooltip": true, prop: "mete", label: "产量（吨）", align: "center" }, { default: a(({ row: e }) => [g("span", null, c(f(A)(e.mete, "kg", "t", 0) || 0), 1)]), _: 1 }), m(r, { "show-overflow-tooltip": true, prop: "ratio", label: "占比", align: "center" }, { default: a(({ row: e }) => [e.type === 2 ? (h(), I("span", Y)) : (h(), I("span", $, c(e.ratio ? e.ratio : 0) + "%", 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  X as default
};
