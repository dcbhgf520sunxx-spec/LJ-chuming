import { ref as _ } from "vue";
import { watch as q } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as x } from "vue";
import { createBlock as v } from "vue";
import { withCtx as u } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as b } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as j } from "vue";
import { createElementVNode as w } from "vue";
import { isRef as M } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { hW as H, u as z, G as T, sA as N, o as P, p as G, L as W } from "../../../shared/runtime.js";
import { g as X, d as Y } from "../../../modules/stock-data-analysis-37c7a329.js";
const Q = { __name: "auxiliary-outbound-and-inbound-analysis-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object }, auxiliaryData: { type: Object, default: () => {
} }, classifyId: { type: Number }, auxList: { type: Array, default: () => [] }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(f, { emit: A }) {
  const { workshopName: R } = H(), h = _([]), k = _(""), L = _(""), V = A, n = f, { visible: y, handleClose: B } = z({ emit: V, props: n, field: "visible" });
  q(() => n.visible, (d) => {
    var s, r, a, l;
    d && (k.value = (r = (s = R.value) == null ? void 0 : s.find((t) => {
      var e;
      return t.id === ((e = n.query) == null ? void 0 : e.workshopId);
    })) == null ? void 0 : r.name, L.value = (l = (a = n.auxList) == null ? void 0 : a.find((t) => t.classifyId === n.classifyId)) == null ? void 0 : l.name, D());
  }, { immediate: true });
  async function D() {
    var r, a, l;
    if (!T((r = n.permission) == null ? void 0 : r.detail)) return false;
    let d = [];
    const s = /* @__PURE__ */ new Map();
    try {
      const t = await X({ ...n.query, classifyId: n.classifyId ? n.classifyId : void 0, basicClass: N.PRODUCTION_AUXILIARY_MATERIALS.V }), e = (a = t == null ? void 0 : t.inCostList) == null ? void 0 : a.map((i) => ({ dateTime: i.dateTime, inCost: i.totalCost })), o = (l = t == null ? void 0 : t.outCostList) == null ? void 0 : l.map((i) => ({ dateTime: i.dateTime, outCost: i.totalCost })), p = [...e, ...o];
      p == null || p.forEach((i) => {
        if (!s.has(i.dateTime)) s.set(i.dateTime, { ...i });
        else {
          const E = s.get(i.dateTime);
          s.set(i.dateTime, { ...E, ...i });
        }
      }), d = Array.from(s.values()) || [];
    } catch (t) {
      console.log("获取辅材出入库数据统计详情失败", t);
    } finally {
      h.value = d;
    }
  }
  const { maxHeight: O } = P({ mainBox: ".auxilary-in-out-bound-class", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: true, navbar: false }, y);
  function S(d) {
    const { columns: s, data: r } = d, a = [];
    return s.forEach((l, t) => {
      if (t === 0) {
        a[t] = "合计";
        return;
      }
      if (l.property === "inCost" || l.property === "outCost") {
        const e = r.map((o) => Number(o[l.property]));
        e.every((o) => isNaN(o)) || (a[t] = e.reduce((o, p) => {
          const I = Number(p);
          return isNaN(I) ? o : o + p;
        }, 0)), a[t] = (a[t] / 1e4).toFixed(4);
      }
    }), a;
  }
  return (d, s) => {
    const r = U, a = F, l = g("common-table"), t = g("common-drawer");
    return x(), v(t, { ref: "drawerRef", title: "辅材出入库统计", modelValue: m(y), "onUpdate:modelValue": s[0] || (s[0] = (e) => M(y) ? y.value = e : null), direction: "rtl", "custom-class": "auxilary-in-out-bound-class", "before-close": m(B), size: "60%" }, { titleAfter: u(() => [c(r, { type: "danger", size: "default" }, { default: u(() => {
      var e, o;
      return [C(" 二级单位： " + b((e = f.branchInfo) != null && e.name ? (o = f.branchInfo) == null ? void 0 : o.name : "全部分支机构"), 1)];
    }), _: 1 }), c(r, { size: "default" }, { default: u(() => [C(" 统计年份： " + b(f.query.yearDate ? m(G)(f.query.yearDate, "{y}") : "-"), 1)]), _: 1 })]), titleRight: u(() => {
      var e, o;
      return [m(T)((e = f.permission) == null ? void 0 : e.download) ? (x(), v(W, { key: 0, fn: m(Y), params: { ...n.query, basicClass: m(N).PRODUCTION_AUXILIARY_MATERIALS.V, classifyId: n.classifyId ? n.classifyId : void 0 }, disabled: !((o = h.value) != null && o.length) }, { default: u(() => s[1] || (s[1] = [C(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : j("", true)];
    }), content: u(() => [c(l, { ref: "tableRef", data: h.value, "max-height": m(O), style: { width: "100%" }, "show-summary": "", "summary-method": S }, { default: u(() => [c(a, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), c(a, { "show-overflow-tooltip": true, prop: "dateTime", label: "月份", align: "center" }), c(a, { "show-overflow-tooltip": true, prop: "inCost", label: "入库(万元)", align: "center" }, { default: u(({ row: e }) => [w("span", null, b(e != null && e.inCost ? (e.inCost / 1e4).toFixed(4) : 0), 1)]), _: 1 }), c(a, { "show-overflow-tooltip": true, prop: "outCost", label: "出库(万元)", align: "center" }, { default: u(({ row: e }) => [w("span", null, b(e != null && e.outCost ? (e.outCost / 1e4).toFixed(4) : 0), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Q as default
};
