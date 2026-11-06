import { ref as _ } from "vue";
import { watch as z } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as x } from "vue";
import { createBlock as N } from "vue";
import { withCtx as l } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as p } from "vue";
import { unref as d } from "vue";
import { createCommentVNode as j } from "vue";
import { createElementVNode as V } from "vue";
import { isRef as q } from "vue";
import { ElTag as H } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { k as O, l as W } from "../../../modules/stock-data-analysis-37c7a329.js";
import { hW as M, u as G, G as k, o as L, p as P, L as U } from "../../../shared/runtime.js";
const Q = { __name: "stock-analysis-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object, default: () => {
} }, basicClass: { type: [Number, String] }, currentDate: { type: String }, branchInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(f, { emit: D }) {
  const { workshopName: T } = M(), y = _([]), g = _(""), S = D, s = f, { visible: h, handleClose: E } = G({ emit: S, props: s, field: "visible" });
  z(() => s.visible, (n) => {
    var t, a;
    n && (g.value = (a = (t = T.value) == null ? void 0 : t.find((o) => {
      var c;
      return o.id === ((c = s.query) == null ? void 0 : c.workshopId);
    })) == null ? void 0 : a.name, A());
  }, { immediate: true });
  async function A() {
    var t;
    if (!k((t = s.permission) == null ? void 0 : t.detail)) return false;
    let n = [];
    try {
      n = await O({ ...s.query, yearDate: s.currentDate }) || [];
    } catch (a) {
      console.log("获取各月仓库库存分析详情失败", a);
    } finally {
      y.value = n;
    }
  }
  const { maxHeight: B } = L({ mainBox: ".monthly-timing-class", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, paginate: false, navbar: false }, h);
  function C(n) {
    const { columns: t, data: a } = n, o = [];
    return t.forEach((c, m) => {
      var e;
      if (m === 0) {
        o[m] = "合计";
        return;
      }
      if (c.property === "amountExcludingVAT") {
        const r = (e = a == null ? void 0 : a.filter((i) => i.isTitle)) == null ? void 0 : e.map((i) => i.amountExcludingVAT);
        r.every((i) => isNaN(i)) || (o[m] = r.reduce((i, w) => {
          const R = Number(w);
          return isNaN(R) ? i : i + w;
        }, 0)), o[m] = (o[m] / 1e4).toFixed(0);
      }
    }), o;
  }
  function I({ row: n, rowIndex: t }) {
    if (n.isTitle) return { fontWeight: "bold", fontSize: "18px" };
  }
  return (n, t) => {
    const a = H, o = F, c = v("common-table"), m = v("common-drawer");
    return x(), N(m, { ref: "drawerRef", title: "月度仓库库存详情", "custom-class": "monthly-timing-class", modelValue: d(h), "onUpdate:modelValue": t[0] || (t[0] = (e) => q(h) ? h.value = e : null), direction: "rtl", "before-close": d(E), size: "60%" }, { titleAfter: l(() => [u(a, { type: "danger", size: "default" }, { default: l(() => {
      var e, r;
      return [b(" 二级单位： " + p((e = f.branchInfo) != null && e.name ? (r = f.branchInfo) == null ? void 0 : r.name : "全部分支机构"), 1)];
    }), _: 1 }), u(a, { size: "default" }, { default: l(() => [b(" 车间： " + p(g.value ? g.value : "全部车间"), 1)]), _: 1 }), u(a, { size: "default" }, { default: l(() => [b(" 月份： " + p(d(P)(f.currentDate, "{y}-{m}") || "-"), 1)]), _: 1 })]), titleRight: l(() => {
      var e, r;
      return [d(k)((e = f.permission) == null ? void 0 : e.download) ? (x(), N(U, { key: 0, fn: d(W), params: { ...s.query, monthDate: s.currentDate }, disabled: !((r = y.value) != null && r.length) }, { default: l(() => t[1] || (t[1] = [b(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])) : j("", true)];
    }), content: l(() => [u(c, { ref: "tableRef", data: y.value, "max-height": d(B), style: { width: "100%" }, "row-style": I, "show-summary": "", "summary-method": C }, { default: l(() => [u(o, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60" }, { default: l(({ row: e }) => [V("span", null, p(e.index || "-"), 1)]), _: 1 }), u(o, { "show-overflow-tooltip": true, prop: "className", label: "类别", align: "center" }), u(o, { "show-overflow-tooltip": true, prop: "amountExcludingVAT", label: "库存金额（万元）", align: "center" }, { default: l(({ row: e }) => [V("span", null, p(e.amountExcludingVAT ? (e.amountExcludingVAT / 1e4).toFixed(0) : "-"), 1)]), _: 1 }), u(o, { "show-overflow-tooltip": true, prop: "ratio", label: "占比（%）", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Q as default
};
