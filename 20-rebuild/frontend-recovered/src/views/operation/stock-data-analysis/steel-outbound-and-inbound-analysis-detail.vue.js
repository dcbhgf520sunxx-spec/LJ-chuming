import { ref as R } from "vue";
import { watch as I } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as T } from "vue";
import { createBlock as M } from "vue";
import { withCtx as i } from "vue";
import { createVNode as m } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as y } from "vue";
import { unref as d } from "vue";
import { createCommentVNode as L } from "vue";
import { createElementVNode as v } from "vue";
import { isRef as j } from "vue";
import { ElTag as q } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { h as A, d as F } from "../../../modules/stock-data-analysis-37c7a329.js";
import { u as H, G as x, sA as C, o as z, p as G, L as P } from "../../../shared/runtime.js";
const K = { __name: "steel-outbound-and-inbound-analysis-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object }, steelData: { type: Object, default: () => {
} }, basicClassType: { type: Number }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(p, { emit: N }) {
  const h = R([]), V = N, n = p, { visible: b, handleClose: B } = H({ emit: V, props: n, field: "visible" });
  I(() => n.visible, (u) => {
    u && E();
  }, { immediate: true });
  async function E() {
    var c, s, r;
    if (!x((c = n.permission) == null ? void 0 : c.detail)) return false;
    let u = [];
    const o = /* @__PURE__ */ new Map();
    try {
      const t = await A({ ...n.query, basicClass: n.basicClassType ? n.basicClassType : C.STEEL.V }), e = (s = t == null ? void 0 : t.inMeteList) == null ? void 0 : s.map((l) => ({ dateTime: l.dateTime, inMete: l.totalMete })), a = (r = t == null ? void 0 : t.outMeteList) == null ? void 0 : r.map((l) => ({ dateTime: l.dateTime, outMete: l.totalMete })), f = [...e, ...a];
      f == null || f.forEach((l) => {
        if (!o.has(l.dateTime)) o.set(l.dateTime, { ...l });
        else {
          const D = o.get(l.dateTime);
          o.set(l.dateTime, { ...D, ...l });
        }
      }), u = Array.from(o.values()) || [];
    } catch (t) {
      console.log("获取钢材出入库数据统计详情失败", t);
    } finally {
      h.value = u;
    }
  }
  const { maxHeight: S } = z({ mainBox: ".steel-in-out-bound-class", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: true, navbar: false }, b);
  function k(u) {
    const { columns: o, data: c } = u, s = [];
    return o.forEach((r, t) => {
      if (t === 0) {
        s[t] = "合计";
        return;
      }
      if (r.property === "inMete" || r.property === "outMete") {
        const e = c.map((a) => Number(a[r.property]));
        e.every((a) => isNaN(a)) || (s[t] = e.reduce((a, f) => {
          const g = Number(f);
          return isNaN(g) ? a : a + f;
        }, 0)), s[t] = (s[t] / 1e4).toFixed(0);
      }
    }), s;
  }
  return (u, o) => {
    const c = q, s = O, r = _("common-table"), t = _("common-drawer");
    return T(), M(t, { ref: "drawerRef", title: "钢材出入库统计", modelValue: d(b), "onUpdate:modelValue": o[0] || (o[0] = (e) => j(b) ? b.value = e : null), direction: "rtl", "custom-class": "steel-in-out-bound-class", "before-close": d(B), size: "60%" }, { titleAfter: i(() => [m(c, { type: "danger", size: "default" }, { default: i(() => {
      var e, a;
      return [w(" 二级单位： " + y((e = p.branchInfo) != null && e.name ? (a = p.branchInfo) == null ? void 0 : a.name : "全部分支机构"), 1)];
    }), _: 1 }), m(c, { size: "default" }, { default: i(() => [w(" 统计年份： " + y(p.query.yearDate ? d(G)(p.query.yearDate, "{y}") : "-"), 1)]), _: 1 })]), titleRight: i(() => {
      var e, a;
      return [d(x)((e = p.permission) == null ? void 0 : e.download) ? (T(), M(P, { key: 0, fn: d(F), params: { ...n.query, basicClass: n.basicClassType ? n.basicClassType : d(C).STEEL.V }, disabled: !((a = h.value) != null && a.length) }, { default: i(() => o[1] || (o[1] = [w(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : L("", true)];
    }), content: i(() => [m(r, { ref: "tableRef", data: h.value, "max-height": d(S), style: { width: "100%" }, "show-summary": "", "summary-method": k }, { default: i(() => [m(s, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), m(s, { "show-overflow-tooltip": true, prop: "dateTime", label: "月份", align: "center" }), m(s, { "show-overflow-tooltip": true, prop: "inMete", label: "入库(万元)", align: "center" }, { default: i(({ row: e }) => [v("span", null, y(e.inMete ? (e.inMete / 1e4).toFixed(0) : 0), 1)]), _: 1 }), m(s, { "show-overflow-tooltip": true, prop: "outMete", label: "出库(万元)", align: "center" }, { default: i(({ row: e }) => [v("span", null, y(e.inMete ? (e.outMete / 1e4).toFixed(0) : 0), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  K as default
};
