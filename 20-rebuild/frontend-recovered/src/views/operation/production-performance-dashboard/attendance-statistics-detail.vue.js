import { ref as w } from "vue";
import { watch as B } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as C } from "vue";
import { createBlock as H } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as r } from "vue";
import { unref as c } from "vue";
import { createElementVNode as b } from "vue";
import { isRef as R } from "vue";
import { ElTag as q } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { dS as T, u as j, o as D, p as E, L } from "../../../shared/runtime.js";
const S = { __name: "attendance-statistics-detail", props: { visible: { type: Boolean, default: false }, query: { type: Object, defaul: () => {
} }, workshopId: { type: Number }, branchInfo: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(i, { emit: _ }) {
  const { workshops: v } = T(), m = w([]), f = w(""), g = _, u = i, { visible: p, handleClose: x } = j({ emit: g, props: u, field: "visible", showHook: k });
  B(() => u.visible, (l) => {
    var t, s;
    l && (f.value = (s = (t = v.value) == null ? void 0 : t.find((n) => n.id === u.workshopId)) == null ? void 0 : s.name);
  }, { immediate: true });
  async function k() {
    let l = [];
    try {
      l = [];
    } catch (t) {
      console.log("获取考勤详情失败", t);
    } finally {
      m.value = l;
    }
  }
  const { maxHeight: N } = D({ mainBox: ".common-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 100, paginate: false });
  return (l, t) => {
    const s = q, n = z, I = y("common-table"), V = y("common-drawer");
    return C(), H(V, { ref: "drawerRef", "destroy-on-close": "", title: "考勤统计统计详情", modelValue: c(p), "onUpdate:modelValue": t[0] || (t[0] = (e) => R(p) ? p.value = e : null), direction: "rtl", "before-close": c(x), size: "50%" }, { titleAfter: a(() => [o(s, { type: "danger", size: "default" }, { default: a(() => {
      var e, h;
      return [d(" 二级单位： " + r((e = i.branchInfo) != null && e.name ? (h = i.branchInfo) == null ? void 0 : h.name : "全部分支机构"), 1)];
    }), _: 1 }), o(s, { size: "default" }, { default: a(() => [d(" 车间： " + r(f.value ? f.value : "全部车间"), 1)]), _: 1 }), o(s, { type: "success", size: "default" }, { default: a(() => [d(" 年份: " + r(i.query.yearDate ? c(E)(i.query.yearDate, "{y}") : "-"), 1)]), _: 1 })]), titleRight: a(() => {
      var e;
      return [o(L, { fn: l.fn, params: { branchCompanyId: u.query.branchCompanyId, workshopId: u.workshopId }, disabled: !((e = m.value) != null && e.length) }, { default: a(() => t[1] || (t[1] = [d(" 下载 ")])), _: 1, __: [1] }, 8, ["fn", "params", "disabled"])];
    }), content: a(() => [o(I, { ref: "tableRef", data: m.value, "show-empty-symbol": false, "max-height": c(N), style: { width: "100%" } }, { default: a(() => [o(n, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "100", type: "index" }), o(n, { "show-overflow-tooltip": true, prop: "totalNum", label: "在册人数", align: "center" }, { default: a(({ row: e }) => [b("span", null, r(e.totalNum ? e.totalNum : 0), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": true, prop: "currentNum", label: "考勤人数", align: "center" }, { default: a(({ row: e }) => [b("span", null, r(e.currentNum ? e.currentNum : 0), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": true, prop: "ratio", label: "差异", align: "center" }, { default: a(({ row: e }) => [b("span", null, r(e.ratio ? e.ratio : 0), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  S as default
};
