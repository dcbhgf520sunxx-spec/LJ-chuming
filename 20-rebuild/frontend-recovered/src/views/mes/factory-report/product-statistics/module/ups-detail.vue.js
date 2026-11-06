import { ref as w } from "vue";
import { inject as M } from "vue";
import { computed as U } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as x } from "vue";
import { createBlock as C } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as G } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as u } from "vue";
import { withDirectives as I } from "vue";
import { unref as r } from "vue";
import { isRef as J } from "vue";
import { ElTag as O } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElPagination as K } from "element-plus";
import { vLoading as Q } from "element-plus";
import { d as X } from "../../../../../modules/product-statistics-2cabaaff.js";
import { u as Y, J as Z, o as $, ba as ee } from "../../../../../shared/runtime.js";
const re = { __name: "ups-detail", props: { visible: { type: Boolean, default: false }, upsInfo: { type: Object }, workshopId: { type: Number }, queryDate: { type: Array, default: () => [] } }, emits: ["update:visible"], setup(m, { emit: z }) {
  const v = w(), D = z, i = m, N = M("permission"), { visible: c, handleClose: q } = Y({ emit: D, props: i, field: "visible", showHook: k }), { handleSizeChange: S, handleCurrentChange: V, total: j, setTotalPage: B, queryPage: d } = Z({ fetchHook: k }), { maxHeight: H } = $({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, v), f = w(false), g = w([]), y = U(() => {
    var a;
    return { projectId: (a = i.upsInfo.project) == null ? void 0 : a.id, workshopId: i.workshopId, startDate: i.queryDate[0], endDate: i.queryDate[1] };
  });
  function R(a) {
    return ee(a, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  async function k() {
    try {
      g.value = [], f.value = true;
      const { content: a = [], totalElements: s } = await X({ ...y.value, ...d });
      g.value = a.map((p, h) => (p.rowId = h + "" + Math.random(), p)), B(s);
    } catch (a) {
      console.log("获取制成品记录详情失败", a);
    } finally {
      f.value = false;
    }
  }
  return (a, s) => {
    const p = O, h = b("print-table"), t = F, W = b("common-table"), P = K, E = b("common-drawer"), L = A("permission"), T = Q;
    return x(), C(E, { ref_key: "drawerRef", ref: v, title: "制成品记录", modelValue: r(c), "onUpdate:modelValue": s[0] || (s[0] = (o) => J(c) ? c.value = o : null), direction: "rtl", "before-close": r(q), size: "70%" }, { titleAfter: n(() => [e(p, { size: "default", effect: "plain" }, { default: n(() => {
      var o, l;
      return [s[1] || (s[1] = G(" 项目：")), _("span", null, u((o = m.upsInfo.project) == null ? void 0 : o.serialNumber) + "-" + u((l = m.upsInfo.project) == null ? void 0 : l.name), 1)];
    }), _: 1, __: [1] })]), titleRight: n(() => [I(e(h, { "api-key": "mesUpsStatisticsList", params: { ...y.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[L, r(N).print]])]), content: n(() => [I((x(), C(W, { data: g.value, "max-height": r(H) - 100, "show-empty-symbol": false, "row-key": "rowId", style: { width: "100%" }, "show-summary": "", "summary-method": R }, { default: n(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" }, { default: n(({ row: o }) => {
      var l;
      return [_("span", null, u(o.monomer ? (l = o.monomer) == null ? void 0 : l.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "area.name", "show-overflow-tooltip": true, label: "区域" }, { default: n(({ row: o }) => {
      var l;
      return [_("span", null, u(o.area ? (l = o.area) == null ? void 0 : l.name : "/"), 1)];
    }), _: 1 }), e(t, { prop: "name", "show-overflow-tooltip": true, label: "名称" }), e(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }), e(t, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "netWeight", label: "单净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "grossWeight", label: "单毛重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalNetWeight", label: "总净重（kg）" }), e(t, { "show-overflow-tooltip": true, align: "center", prop: "totalGrossWeight", label: "总毛重（kg）" })]), _: 1 }, 8, ["data", "max-height"])), [[T, f.value]]), e(P, { total: r(j), "current-page": r(d).pageNumber, "page-size": r(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(S), onCurrentChange: r(V) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  re as default
};
