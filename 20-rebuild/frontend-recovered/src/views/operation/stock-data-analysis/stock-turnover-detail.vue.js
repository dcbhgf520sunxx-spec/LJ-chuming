import { ref as v } from "vue";
import { watch as T } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as x } from "vue";
import { createBlock as g } from "vue";
import { withCtx as i } from "vue";
import { createVNode as r } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as w } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as D } from "vue";
import { createElementVNode as S } from "vue";
import { isRef as j } from "vue";
import { ElTag as q } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { m as H, n as E } from "../../../modules/stock-data-analysis-37c7a329.js";
import { hW as O, u as G, G as C, i as k, o as L, L as M } from "../../../shared/runtime.js";
const U = { __name: "stock-turnover-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(f, { emit: _ }) {
  const { workshopName: N } = O(), c = v([]), b = v(""), V = _, m = f, { visible: p, handleClose: B } = G({ emit: V, props: m, field: "visible" });
  T(() => m.visible, (t) => {
    var n, l;
    t && (b.value = (l = (n = N.value) == null ? void 0 : n.find((a) => {
      var s;
      return a.id === ((s = m.query) == null ? void 0 : s.workshopId);
    })) == null ? void 0 : l.name, F());
  }, { immediate: true });
  async function F() {
    var n;
    if (!C((n = m.permission) == null ? void 0 : n.detail)) return false;
    let t = [];
    try {
      if (t = await H({ ...m.query }) || [], (t == null ? void 0 : t.length) > 0) {
        const a = t == null ? void 0 : t.reduce((o, e) => k(e == null ? void 0 : e.inCost) ? o + Number(e == null ? void 0 : e.inCost) : o, 0), s = t == null ? void 0 : t.reduce((o, e) => k(e == null ? void 0 : e.outCost) ? o + Number(e == null ? void 0 : e.outCost) : o, 0);
        t == null || t.forEach((o) => {
          o.rate = Number(o.outCost) && Number(o.inCost) ? (o.outCost / o.inCost * 100).toFixed(2) : 0, o.inCost = (o.inCost / 1e4).toFixed(0), o.outCost = (o.outCost / 1e4).toFixed(0);
        });
        t.push({ type: 2, index: "合计", inCost: (a / 1e4).toFixed(0), outCost: (s / 1e4).toFixed(0), rate: s && a ? (s / a * 100).toFixed(2) : 0 });
      }
    } catch (l) {
      console.log("获取库存周转率详情失败", l);
    } finally {
      c.value = t;
    }
  }
  const { maxHeight: I } = L({ mainBox: ".stock-turnover-class", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: false, navbar: false }, p);
  function R({ row: t, rowIndex: n }) {
    if (t.index === "合计") return { position: "sticky", bottom: "0 !important", zIndex: 1 };
  }
  return (t, n) => {
    const l = q, a = z, s = y("common-table"), o = y("common-drawer");
    return x(), g(o, { ref: "drawerRef", "custom-class": "stock-turnover-class", title: "库存周转率详情", modelValue: u(p), "onUpdate:modelValue": n[0] || (n[0] = (e) => j(p) ? p.value = e : null), direction: "rtl", "before-close": u(B), size: "60%" }, { titleAfter: i(() => [r(l, { type: "danger", size: "default" }, { default: i(() => {
      var e, d;
      return [h(" 二级单位： " + w((e = f.branchInfo) != null && e.name ? (d = f.branchInfo) == null ? void 0 : d.name : "全部分支机构"), 1)];
    }), _: 1 }), r(l, { size: "default" }, { default: i(() => [h(" 车间： " + w(b.value ? b.value : "全部车间"), 1)]), _: 1 })]), titleRight: i(() => {
      var e, d;
      return [u(C)((e = f.permission) == null ? void 0 : e.download) ? (x(), g(M, { key: 0, fn: u(E), params: { ...m.query }, disabled: !((d = c.value) != null && d.length) }, { default: i(() => n[1] || (n[1] = [h(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : D("", true)];
    }), content: i(() => [r(s, { ref: "tableRef", data: c.value, "max-height": u(I), "show-empty-symbol": false, "row-style": R, style: { width: "100%" } }, { default: i(() => [r(a, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "90", type: "index" }, { default: i(({ row: e, $index: d }) => [S("span", null, w(e.type === 2 ? "合计" : d + 1), 1)]), _: 1 }), r(a, { "show-overflow-tooltip": true, prop: "dateTime", label: "日期", align: "center" }), r(a, { "show-overflow-tooltip": true, prop: "inCost", label: "入库金额(万元)", align: "center" }), r(a, { "show-overflow-tooltip": true, prop: "outCost", label: "出库金额(万元)", align: "center" }), r(a, { "show-overflow-tooltip": true, prop: "rate", label: "库存周转率", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  U as default
};
