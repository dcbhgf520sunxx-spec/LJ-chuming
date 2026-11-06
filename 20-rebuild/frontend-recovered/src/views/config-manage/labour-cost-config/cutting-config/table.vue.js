import { inject as O } from "vue";
import { ref as C } from "vue";
import { reactive as B } from "vue";
import { computed as I } from "vue";
import { onMounted as V } from "vue";
import { watch as q } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as e } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as o } from "vue";
import { withCtx as _ } from "vue";
import { Fragment as d } from "vue";
import { renderList as f } from "vue";
import { toDisplayString as p } from "vue";
import { unref as u } from "vue";
import { createBlock as $ } from "vue";
import { createCommentVNode as g } from "vue";
import { createElementVNode as F } from "vue";
import { withDirectives as T } from "vue";
import { nextTick as M } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { ElButton as G } from "element-plus";
import { ElPopconfirm as H } from "element-plus";
import { ElTable as W } from "element-plus";
import { i as X, j as J } from "../../../../modules/cutting-config-59e818a6.js";
import { b as K, d as Q } from "../../../../modules/project-cutting-config-562d5e35.js";
import { _ as U, e0 as Z, e1 as ee, bV as z, ej as k, eb as te, G as ae, e2 as N, ec as ne } from "../../../../shared/runtime.js";
const ie = { class: "table-container" }, se = { key: 1 }, oe = { key: 0 }, re = { key: 1, class: "direction" }, ce = { key: 2, class: "direction" }, le = { key: 3 }, de = { key: 1 }, pe = { key: 1 }, _e = { key: 0, class: "price-text" }, ue = { key: 1 }, me = { key: 0 }, fe = { key: 1 }, ge = { key: 0, class: "price-text" }, ye = { key: 1 }, be = { key: 0 }, he = { key: 1 }, ke = { __name: "table", setup(Pe, { expose: x }) {
  const D = O("parentData"), y = O("projectData"), { headerRef: c } = D, P = C([]), b = B({ pageSize: 10, pageNumber: 1, sort: "id.asc" }), v = C(0), S = I(() => y ? K : X), R = I(() => y ? Q : J), m = async (l) => {
    if (!ae(k.get)) return N("warning", "暂无权限");
    try {
      const { content: r, totalElements: i } = await S.value({ ...b, statisticsConfigStatisticsMode: c.value.radio, projectId: y ? l || y.contractProjectId : null });
      v.value = i;
      const h = r.map((s) => ({ id: s.id, statisticsMode: s.statisticsMode, machinePartType: s.machinePartType, steelClassificationName: s.steelClassificationName, specificationPrefixTypeList: s.specificationPrefixTypeList, processIdList: s.processIdList, processNameList: s.processNameList, measurementManner: s.measurementManner, pricingManner: s.pricingManner, organizationInsidePrice: s.organizationInsidePrice, organizationOutsidePrice: s.organizationOutsidePrice, detailList: s.detailList, steelClassificationId: s.steelClassificationId, fixedPrice: s.fixedPrice }));
      P.value = ne(h);
    } catch (r) {
      console.log(r);
    }
  }, E = async (l) => {
    try {
      await R.value([l.id]), N("success", "删除成功"), m();
    } catch (r) {
      console.log(r);
    }
  }, j = async (l) => {
    const r = c.value.radio;
    r === 2 ? (Object.assign(c.value.createRef.reverSetFromData, { id: l.id }), M(() => {
      c.value.createRef.currentComponentRef.getProcessInfo();
    })) : r === 1 && (Object.assign(c.value.createRef.calculationFormData, { id: l.id, statisticsMode: l.statisticsMode }), M(() => {
      var i;
      c.value.createRef.currentComponentRef.getDrillConfigInfo && ((i = c.value.createRef.currentComponentRef) == null || i.getDrillConfigInfo());
    })), c.value.createRef.visible = true;
  };
  return V(() => {
    m();
  }), q(() => c.value.radio, (l) => {
    l && (b.pageNumber = 1, b.pageSize = 10), m();
  }), x({ getSparePartsConfigList: m }), (l, r) => {
    const i = Y, h = G, s = H, w = W, L = A("permission");
    return e(), a("div", ie, [o(w, { data: P.value, border: "", fit: "" }, { default: _(() => [o(i, { type: "index", label: "序号", width: "55", align: "center" }), o(i, { prop: "machinePartTypeName", label: "零件类型", align: "center" }), o(i, { prop: "steelClassificationName", label: "零件分类", align: "center", "show-overflow-tooltip": "" }), o(i, { label: "零件前缀", align: "center", "min-width": "140", "show-overflow-tooltip": "" }, { default: _(({ row: n }) => [(e(true), a(d, null, f(n.specificationPrefixTypeList, (t) => (e(), a("span", { key: t }, p(`【 ${t} 】`), 1))), 128))]), _: 1 }), o(i, { label: "生产方式", align: "center" }, { default: _(({ row: n }) => [n.processNameList.length ? (e(true), a(d, { key: 0 }, f(n.processNameList, (t) => (e(), a("span", { key: t }, p(`【 ${t} 】`), 1))), 128)) : (e(), a("span", se, "-"))]), _: 1 }), o(i, { prop: "statisticsModeName", label: "统计模式", align: "center" }), o(i, { prop: "measurementMannerName", label: "计量方式", align: "center" }), u(c).radio !== 2 ? (e(), $(i, { key: 0, label: "板厚（mm）", align: "center", class: "mm-container", "min-width": "140" }, { default: _(({ row: n }) => [n.statisticsMode === 3 ? (e(), a(d, { key: 0 }, [n.pricingManner === 1 ? (e(true), a(d, { key: 0 }, f(n.detailList, (t) => (e(), a("div", { key: t, class: "detailList-container" }, [t.numberOne && t.comparisonOperatorOne ? (e(), a("span", oe, p(t.numberOne), 1)) : g("", true), t.numberOne && t.comparisonOperatorOne ? (e(), a("span", re, p(u(Z).V[t.comparisonOperatorOne].L), 1)) : g("", true), r[0] || (r[0] = F("span", null, "X", -1)), t.numberTwo && t.comparisonOperatorTwo ? (e(), a("span", ce, p(u(ee).V[t.comparisonOperatorTwo].L), 1)) : g("", true), t.numberTwo && t.comparisonOperatorTwo ? (e(), a("span", le, p(t.numberTwo), 1)) : g("", true)]))), 128)) : (e(), a("span", de, "-"))], 64)) : (e(), a("span", pe, "-"))]), _: 1 })) : g("", true), o(i, { label: "编制内单价（元）", align: "right" }, { default: _(({ row: n }) => [n.detailList ? (e(true), a(d, { key: 0 }, f(n.detailList, (t) => (e(), a(d, { key: t.id }, [t.organizationInsidePrice ? (e(), a("div", _e, p(u(z)(t.organizationInsidePrice)), 1)) : (e(), a("span", ue, "-"))], 64))), 128)) : (e(), a(d, { key: 1 }, [n.organizationInsidePrice ? (e(), a("span", me, p(n.organizationInsidePrice), 1)) : (e(), a("span", fe, "-"))], 64))]), _: 1 }), o(i, { label: "编制外单价（元）", align: "right" }, { default: _(({ row: n }) => [n.detailList ? (e(true), a(d, { key: 0 }, f(n.detailList, (t) => (e(), a(d, { key: t.id }, [t.organizationOutsidePrice ? (e(), a("div", ge, p(u(z)(t.organizationOutsidePrice)), 1)) : (e(), a("span", ye, "-"))], 64))), 128)) : (e(), a(d, { key: 1 }, [n.organizationOutsidePrice ? (e(), a("span", be, p(n.organizationOutsidePrice), 1)) : (e(), a("span", he, "-"))], 64))]), _: 1 }), o(i, { label: "操作", align: "center" }, { default: _(({ row: n }) => [T(o(h, { type: "primary", icon: "el-icon-edit", size: "default", onClick: (t) => j(n) }, null, 8, ["onClick"]), [[L, u(k).edit]]), o(s, { title: "确定删除本条数据吗?", onConfirm: (t) => E(n), "hide-icon": "" }, { reference: _(() => [T(o(h, { size: "default", type: "danger", icon: "el-icon-delete" }, null, 512), [[L, u(k).del]])]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data"]), o(te, { "request-data": b, total: v.value, onHandleChange: m }, null, 8, ["request-data", "total"])]);
  };
} }, Ie = U(ke, [["__scopeId", "data-v-0ca65b05"]]);
export {
  Ie as default
};
