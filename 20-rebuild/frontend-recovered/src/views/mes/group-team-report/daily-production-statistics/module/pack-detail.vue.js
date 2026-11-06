import { ref as c } from "vue";
import { watch as G } from "vue";
import { inject as O } from "vue";
import { computed as A } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as D } from "vue";
import { createBlock as V } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as t } from "vue";
import { unref as s } from "vue";
import { withDirectives as P } from "vue";
import { toDisplayString as r } from "vue";
import { isRef as $ } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { vLoading as X } from "element-plus";
import { a as Y } from "../../../../../modules/daily-production-statistics-18379024.js";
import { _ as Z, u as ee, J as te, o as ae, fv as le, q as oe, nC as ne } from "../../../../../shared/runtime.js";
const ie = { class: "header" }, se = { __name: "pack-detail", props: { modelValue: { type: Boolean, require: true }, packDetailData: { type: Object, default: () => {
} }, packDetailType: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(S, { emit: z }) {
  const I = z, _ = S, j = c(void 0), { visible: u, handleClose: H } = ee({ emit: I, props: _, showHook: q }), { handleSizeChange: W, handleCurrentChange: B, total: N, setTotalPage: R, queryPage: v } = te({ fetchHook: g });
  G(u, (p) => {
    p && (j.value = void 0, g());
  });
  const x = c([]), k = c(), f = c(false), d = O("query"), w = c(), m = c(), C = A(() => {
    var p;
    return { projectId: m.value || void 0, workShopId: ((p = _.packDetailData) == null ? void 0 : p.workShopId) || void 0, monomerId: w.value || void 0, dateTime: _.packDetailType === "total" || d == null ? void 0 : d.dateTime };
  }), { maxHeight: T } = ae({ mainBox: ".daily-production-statistics-pack-detail", extraBox: [".el-drawer__header", ".header"], wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, () => k.value.loaded);
  async function g() {
    if (!u.value || f.value) return;
    let p = [];
    f.value = true;
    try {
      const { content: a = [], totalElements: b } = await Y({ ...C.value, ...v });
      p = a, R(b);
    } catch (a) {
      console.log(a);
    } finally {
      x.value = p, f.value = false;
    }
  }
  function q() {
    m.value = (d == null ? void 0 : d.projectId) || void 0;
  }
  return (p, a) => {
    const b = y("print-table"), n = K, F = y("common-table"), E = Q, L = y("common-drawer"), M = J("permission"), U = X;
    return D(), V(L, { ref_key: "drawerRef", ref: k, title: "打包清单", "close-on-click-modal": false, modelValue: s(u), "onUpdate:modelValue": a[2] || (a[2] = (h) => $(u) ? u.value = h : null), direction: "rtl", "before-close": s(H), "custom-class": "daily-production-statistics-pack-detail", size: "80%" }, { titleAfter: l(() => a[3] || (a[3] = [])), titleRight: l(() => a[4] || (a[4] = [])), content: l(() => {
      var h;
      return [o("div", ie, [o("div", null, [t(s(le), { modelValue: m.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => m.value = e), class: "filter-item", style: { width: "300px" }, clearable: "", placeholder: "可选择项目搜索", onChange: g }, null, 8, ["modelValue"]), t(s(oe), { ref: "monomerRef", modelValue: w.value, "onUpdate:modelValue": a[1] || (a[1] = (e) => w.value = e), "project-id": m.value, placeholder: "可选择单体", clearable: "", default: false, class: "filter-item", style: { width: "200px", "margin-left": "10px" }, onChange: g }, null, 8, ["modelValue", "project-id"])]), P(t(b, { "api-key": "mesDailyStatisticsPackDetail", params: { ...C.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[M, (h = s(ne)) == null ? void 0 : h.PackDetailPrint]])]), P((D(), V(F, { data: x.value, "empty-text": "暂无数据", "max-height": s(T) }, { default: l(() => [t(n, { label: "序号", type: "index", align: "center", width: "60" }), t(n, { prop: "monomer", label: "单体", align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [o("span", null, r(e.monomer.name || "-"), 1)]), _: 1 }), t(n, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [o("span", null, r(e.serialNumber || "-"), 1)]), _: 1 }), t(n, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [o("span", null, r(e.specification || "-"), 1)]), _: 1 }), t(n, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [o("span", null, r(e.material || "-"), 1)]), _: 1 }), t(n, { prop: "length", label: `长度
（mm）`, align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [o("span", null, r(e.length || "-"), 1)]), _: 1 }), t(n, { prop: "netWeight", label: `单净重
（kg）`, align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => {
        var i;
        return [o("span", null, r(((i = e.netWeight) == null ? void 0 : i.toFixed(2)) || "-"), 1)];
      }), _: 1 }), t(n, { prop: "grossWeight", label: `单毛重
（kg）`, align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => {
        var i;
        return [o("span", null, r(((i = e.grossWeight) == null ? void 0 : i.toFixed(2)) || "-"), 1)];
      }), _: 1 }), t(n, { prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [o("span", null, r(e.quantity || "-"), 1)]), _: 1 }), t(n, { prop: "totalNetWeight", label: `总净重
(t)`, align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => {
        var i;
        return [o("span", null, r(((i = e.totalNetWeight) == null ? void 0 : i.toFixed(2)) || "-"), 1)];
      }), _: 1 }), t(n, { prop: "totalGrossWeight", label: `总毛重
(t)`, align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => {
        var i;
        return [o("span", null, r(((i = e.totalGrossWeight) == null ? void 0 : i.toFixed(2)) || "-"), 1)];
      }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[U, f.value]]), t(E, { total: s(N), "current-page": s(v).pageNumber, "page-size": s(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(W), onCurrentChange: s(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ce = Z(se, [["__scopeId", "data-v-fa48fe6a"]]);
export {
  ce as default
};
