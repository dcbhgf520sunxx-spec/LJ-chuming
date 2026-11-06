import { inject as P } from "vue";
import { ref as C } from "vue";
import { reactive as A } from "vue";
import { computed as T } from "vue";
import { onMounted as F } from "vue";
import { watch as $ } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as e } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as p } from "vue";
import { withCtx as m } from "vue";
import { Fragment as u } from "vue";
import { renderList as f } from "vue";
import { toDisplayString as c } from "vue";
import { unref as l } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as o } from "vue";
import { createElementVNode as M } from "vue";
import { withDirectives as D } from "vue";
import { nextTick as Y } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElButton as H } from "element-plus";
import { ElPopconfirm as W } from "element-plus";
import { ElTable as J } from "element-plus";
import { f as K, h as Q } from "../../../../modules/drilling-config-d5ae6cbb.js";
import { g as U, d as Z } from "../../../../modules/project-drilling-config-e57c94dd.js";
import { _ as ee, e0 as I, e1 as x, bV as z, el as h, eb as te, G as ae, e2 as N, ec as ne } from "../../../../shared/runtime.js";
const se = { class: "table-container" }, ie = { key: 1 }, oe = { key: 0 }, re = { key: 1, class: "direction" }, ce = { key: 2, class: "direction" }, le = { key: 3 }, de = { key: 1 }, pe = { key: 1 }, ue = { key: 0 }, _e = { key: 1, class: "direction" }, me = { key: 2, class: "direction" }, fe = { key: 3 }, ye = { key: 1 }, ge = { key: 1 }, ke = { key: 0, class: "price-text" }, be = { key: 1 }, he = { key: 0 }, Oe = { key: 1 }, ve = { key: 0, class: "price-text" }, Le = { key: 1 }, Pe = { key: 0 }, Ce = { key: 1 }, Te = { __name: "table", setup(Me, { expose: w }) {
  const k = P("projectData"), E = P("parentData"), { headerRef: r } = E, O = C([]), b = A({ pageSize: 10, pageNumber: 1, sort: "id.asc" }), v = C(0), S = T(() => k ? U : K), R = T(() => k ? Z : Q), g = async () => {
    if (!ae(h.get)) return N("warning", "暂无权限");
    try {
      const { content: d, totalElements: _ } = await S.value({ ...b, statisticsConfigStatisticsMode: r.value.radio, projectId: k ? k.contractProjectId : null });
      v.value = _;
      const s = d.map((i) => ({ id: i.id, statisticsMode: i.statisticsMode, machinePartType: i.machinePartType, steelClassificationName: i.steelClassificationName, specificationPrefixTypeList: i.specificationPrefixTypeList, processIdList: i.processIdList, processNameList: i.processNameList, measurementManner: i.measurementManner, pricingManner: i.pricingManner, organizationInsidePrice: i.organizationInsidePrice, organizationOutsidePrice: i.organizationOutsidePrice, detailList: i.detailList, steelClassificationId: i.steelClassificationId, fixedPrice: i.fixedPrice }));
      O.value = ne(s);
    } catch (d) {
      console.log(d);
    }
  }, V = async (d) => {
    try {
      await R.value([d.id]), N("success", "删除成功"), g();
    } catch (_) {
      console.log(_);
    }
  }, j = async (d) => {
    const _ = r.value.radio;
    _ === 2 ? Object.assign(r.value.createRef.reverSetFromData, d) : _ === 1 && Object.assign(r.value.createRef.calculationFormData, { id: d.id, statisticsMode: d.statisticsMode }), r.value.createRef.visible = true, Y(() => {
      var s;
      r.value.createRef.currentComponentRef.getDrillConfigInfo && ((s = r.value.createRef.currentComponentRef) == null || s.getDrillConfigInfo());
    });
  };
  return F(() => {
    g();
  }), $(() => r.value.radio, (d) => {
    d && (b.pageNumber = 1, b.pageSize = 10), g();
  }), w({ getDrillConfigList: g }), (d, _) => {
    const s = G, i = H, B = W, q = J, L = X("permission");
    return e(), a("div", se, [p(q, { data: O.value, border: "", fit: "" }, { default: m(() => [p(s, { type: "index", label: "序号", width: "55", align: "center" }), p(s, { prop: "machinePartTypeName", label: "零件类型", align: "center" }), p(s, { prop: "steelClassificationName", label: "零件分类", align: "center", "show-overflow-tooltip": "" }), p(s, { label: "零件前缀", align: "center", "min-width": "140", "show-overflow-tooltip": "" }, { default: m(({ row: n }) => [(e(true), a(u, null, f(n.specificationPrefixTypeList, (t) => (e(), a("span", { key: t }, c(`【 ${t} 】`), 1))), 128))]), _: 1 }), l(r).radio !== 2 ? (e(), y(s, { key: 0, label: "生产方式", align: "center" }, { default: m(({ row: n }) => [n.processNameList.length ? (e(true), a(u, { key: 0 }, f(n.processNameList, (t) => (e(), a("span", { key: t }, c(t), 1))), 128)) : (e(), a("span", ie, "-"))]), _: 1 })) : o("", true), p(s, { prop: "statisticsModeName", label: "统计模式", align: "center" }), p(s, { prop: "measurementMannerName", label: "计量方式", align: "center" }), l(r).radio !== 2 ? (e(), y(s, { key: 1, label: "板厚（mm）", align: "center", class: "mm-container", "min-width": "140" }, { default: m(({ row: n }) => [n.statisticsMode === 3 ? (e(), a(u, { key: 0 }, [n.pricingManner === 1 ? (e(true), a(u, { key: 0 }, f(n.detailList, (t) => (e(), a("div", { key: t, class: "detailList-container" }, [t.numberOne && t.comparisonOperatorOne ? (e(), a("span", oe, c(t.numberOne), 1)) : o("", true), t.numberOne && t.comparisonOperatorOne ? (e(), a("span", re, c(l(I).V[t.comparisonOperatorOne].L), 1)) : o("", true), _[0] || (_[0] = M("span", null, "X", -1)), t.numberTwo && t.comparisonOperatorTwo ? (e(), a("span", ce, c(l(x).V[t.comparisonOperatorTwo].L), 1)) : o("", true), t.numberTwo && t.comparisonOperatorTwo ? (e(), a("span", le, c(t.numberTwo), 1)) : o("", true)]))), 128)) : (e(), a("span", de, "-"))], 64)) : (e(), a("span", pe, "-"))]), _: 1 })) : o("", true), l(r).radio !== 2 ? (e(), y(s, { key: 2, label: "孔径（mm）", align: "center", "min-width": "140" }, { default: m(({ row: n }) => [n.statisticsMode === 3 ? (e(), a(u, { key: 0 }, [n.pricingManner === 2 ? (e(true), a(u, { key: 0 }, f(n.detailList, (t) => (e(), a("div", { key: t, class: "detailList-container" }, [t.numberOne && t.comparisonOperatorOne ? (e(), a("span", ue, c(t.numberOne), 1)) : o("", true), t.numberOne && t.comparisonOperatorOne ? (e(), a("span", _e, c(l(I).V[t.comparisonOperatorOne].L), 1)) : o("", true), _[1] || (_[1] = M("span", null, "X", -1)), t.numberTwo && t.comparisonOperatorTwo ? (e(), a("span", me, c(l(x).V[t.comparisonOperatorTwo].L), 1)) : o("", true), t.numberTwo && t.comparisonOperatorTwo ? (e(), a("span", fe, c(t.numberTwo), 1)) : o("", true)]))), 128)) : (e(), a("span", ye, "-"))], 64)) : (e(), a("span", ge, "-"))]), _: 1 })) : o("", true), l(r).radio !== 2 ? (e(), y(s, { key: 3, label: "编制内单价（元）", align: "center" }, { default: m(({ row: n }) => [n.statisticsMode === 3 ? (e(true), a(u, { key: 0 }, f(n.detailList, (t) => (e(), a(u, { key: t.id }, [t.organizationInsidePrice ? (e(), a("div", ke, c(l(z)(t.organizationInsidePrice)), 1)) : (e(), a("span", be, "-"))], 64))), 128)) : n.statisticsMode === 2 ? (e(), a(u, { key: 1 }, [n.organizationInsidePrice ? (e(), a("div", he, c(n.organizationInsidePrice), 1)) : (e(), a("span", Oe, "-"))], 64)) : o("", true)]), _: 1 })) : o("", true), l(r).radio !== 2 ? (e(), y(s, { key: 4, label: "编制外单价（元）", align: "center" }, { default: m(({ row: n }) => [n.statisticsMode === 3 ? (e(true), a(u, { key: 0 }, f(n.detailList, (t) => (e(), a(u, { key: t.id }, [t.organizationOutsidePrice ? (e(), a("div", ve, c(l(z)(t.organizationOutsidePrice)), 1)) : (e(), a("span", Le, "-"))], 64))), 128)) : n.statisticsMode === 2 ? (e(), a(u, { key: 1 }, [n.organizationOutsidePrice ? (e(), a("div", Pe, c(n.organizationOutsidePrice), 1)) : (e(), a("span", Ce, "-"))], 64)) : o("", true)]), _: 1 })) : o("", true), l(r).radio === 2 ? (e(), y(s, { key: 5, prop: "fixedPrice", label: "一口价", align: "center" })) : o("", true), p(s, { label: "操作", align: "center" }, { default: m(({ row: n }) => [D(p(i, { type: "primary", icon: "el-icon-edit", size: "default", onClick: (t) => j(n) }, null, 8, ["onClick"]), [[L, l(h).edit]]), p(B, { title: "确定删除本条数据吗?", onConfirm: (t) => V(n), "hide-icon": "" }, { reference: m(() => [D(p(i, { size: "default", type: "danger", icon: "el-icon-delete" }, null, 512), [[L, l(h).del]])]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data"]), p(te, { "request-data": b, total: v.value, onHandleChange: g }, null, 8, ["request-data", "total"])]);
  };
} }, Ne = ee(Te, [["__scopeId", "data-v-d73f91ba"]]);
export {
  Ne as default
};
