import { inject as C } from "vue";
import { ref as P } from "vue";
import { reactive as q } from "vue";
import { computed as M } from "vue";
import { onMounted as A } from "vue";
import { watch as $ } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as c } from "vue";
import { withCtx as m } from "vue";
import { Fragment as u } from "vue";
import { renderList as k } from "vue";
import { toDisplayString as l } from "vue";
import { unref as d } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as w } from "vue";
import { withDirectives as N } from "vue";
import { nextTick as W } from "vue";
import { ElTableColumn as F } from "element-plus";
import { ElButton as X } from "element-plus";
import { ElPopconfirm as Y } from "element-plus";
import { ElTable as H } from "element-plus";
import { j as J, k as K, l as Q, m as U } from "../../../../modules/project-group-welding-config-ee2755b6.js";
import { _ as Z, e0 as T, e1 as D, eo as O, eb as ee, G as te, e2 as I, ec as ae } from "../../../../shared/runtime.js";
const ne = { class: "table-container" }, se = { key: 1 }, oe = { key: 0 }, ie = { key: 1, class: "direction" }, re = { key: 2, class: "direction" }, ce = { key: 3 }, le = { key: 1 }, de = { key: 1 }, pe = { key: 0 }, me = { key: 1, class: "direction" }, _e = { key: 2, class: "direction" }, ue = { key: 3 }, ge = { key: 1 }, fe = { key: 1 }, be = { key: 0 }, ye = { key: 1 }, ke = { key: 0 }, Oe = { key: 1 }, he = { __name: "table", setup(Le, { expose: x }) {
  const b = C("projectData"), z = C("parentData"), { headerRef: p } = z, h = P([]), y = q({ pageSize: 10, pageNumber: 1, sort: "id.asc" }), L = P(0), S = M(() => b ? J : K), E = M(() => b ? Q : U), g = async () => {
    if (!te(O.get)) return I("warning", "暂无权限");
    try {
      const { content: r, totalElements: _ } = await S.value({ ...y, projectId: b ? b.contractProjectId : null });
      L.value = _;
      const o = r.map((s) => ({ id: s.id, statisticsMode: s.statisticsMode, assembleConfigName: s.assembleConfigName, steelClassificationName: s.steelClassificationName, assembleSpecPrefixList: s.assembleSpecPrefixList, processIdList: s.processIdList, processNameList: s.processNameList, measurementManner: s.measurementManner, pricingManner: s.pricingManner, organizationInsidePrice: s.organizationInsidePrice, organizationOutsidePrice: s.organizationOutsidePrice, detailList: s.detailList, steelClassificationId: s.steelClassificationId, fixedPrice: s.fixedPrice }));
      h.value = ae(o);
    } catch (r) {
      console.log(r);
    }
  }, j = async (r) => {
    try {
      await E.value([r.id]), I("success", "删除成功"), g();
    } catch (_) {
      console.log(_);
    }
  }, B = async (r) => {
    Object.assign(p.value.createRef.calculationFormData, { id: r.id, statisticsMode: r.statisticsMode, pricingManner: r.pricingManner }), p.value.createRef.visible = true, W(() => {
      p.value.createRef.currentComponentRef.getDrillConfigInfo();
    });
  };
  return A(() => {
    g();
  }), $(() => p.value.radio, (r) => {
    r && (y.pageNumber = 1, y.pageSize = 10), g();
  }), x({ getDrillConfigList: g }), (r, _) => {
    const o = F, s = X, V = Y, R = H, v = G("permission");
    return t(), a("div", ne, [c(R, { data: h.value, border: "", fit: "" }, { default: m(() => [c(o, { type: "index", label: "序号", width: "55", align: "center" }), c(o, { prop: "assembleConfigName", label: "部件类型", align: "center" }), c(o, { label: "部件规格前缀", align: "center", "min-width": "140", "show-overflow-tooltip": "" }, { default: m(({ row: n }) => [(t(true), a(u, null, k(n.assembleSpecPrefixList, (e) => (t(), a("span", { key: e }, l(`【 ${e} 】`), 1))), 128))]), _: 1 }), c(o, { label: "生产工序", align: "center", "min-width": "140", "show-overflow-tooltip": "" }, { default: m(({ row: n }) => [n.processNameList.length ? (t(true), a(u, { key: 0 }, k(n.processNameList, (e) => (t(), a("span", { key: e }, l(`【 ${e} 】`), 1))), 128)) : (t(), a("span", se, "-"))]), _: 1 }), c(o, { prop: "statisticsModeName", label: "统计模式", align: "center" }), c(o, { prop: "measurementMannerName", label: "计量方式", align: "center" }), d(p).radio !== 2 ? (t(), f(o, { key: 0, label: "截面", align: "center", class: "mm-container", "min-width": "140" }, { default: m(({ row: n }) => [n.statisticsMode === 1 ? (t(), a(u, { key: 0 }, [n.pricingManner === 1 ? (t(true), a(u, { key: 0 }, k(n.detailList, (e) => (t(), a("div", { key: e, class: "detailList-container" }, [e.numberOne && e.comparisonOperatorOne ? (t(), a("span", oe, l(e.numberOne), 1)) : i("", true), e.numberOne && e.comparisonOperatorOne ? (t(), a("span", ie, l(d(T).V[e.comparisonOperatorOne].L), 1)) : i("", true), _[0] || (_[0] = w("span", null, "X", -1)), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", re, l(d(D).V[e.comparisonOperatorTwo].L), 1)) : i("", true), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", ce, l(e.numberTwo), 1)) : i("", true)]))), 128)) : (t(), a("span", le, "-"))], 64)) : (t(), a("span", de, "-"))]), _: 1 })) : i("", true), d(p).radio !== 2 ? (t(), f(o, { key: 1, label: "腹板厚度（mm）", align: "center", "min-width": "140" }, { default: m(({ row: n }) => [n.statisticsMode === 1 ? (t(), a(u, { key: 0 }, [n.pricingManner === 2 ? (t(true), a(u, { key: 0 }, k(n.detailList, (e) => (t(), a("div", { key: e, class: "detailList-container" }, [e.numberOne && e.comparisonOperatorOne ? (t(), a("span", pe, l(e.numberOne), 1)) : i("", true), e.numberOne && e.comparisonOperatorOne ? (t(), a("span", me, l(d(T).V[e.comparisonOperatorOne].L), 1)) : i("", true), _[1] || (_[1] = w("span", null, "X", -1)), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", _e, l(d(D).V[e.comparisonOperatorTwo].L), 1)) : i("", true), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", ue, l(e.numberTwo), 1)) : i("", true)]))), 128)) : (t(), a("span", ge, "-"))], 64)) : (t(), a("span", fe, "-"))]), _: 1 })) : i("", true), d(p).radio !== 2 ? (t(), f(o, { key: 2, label: "编制内单价（元）", align: "right" }, { default: m(({ row: n }) => [n.organizationInsidePrice ? (t(), a("div", be, l(n.organizationInsidePrice), 1)) : (t(), a("span", ye, "-"))]), _: 1 })) : i("", true), d(p).radio !== 2 ? (t(), f(o, { key: 3, label: "编制外单价（元）", align: "right" }, { default: m(({ row: n }) => [n.organizationOutsidePrice ? (t(), a("div", ke, l(n.organizationOutsidePrice), 1)) : (t(), a("span", Oe, "-"))]), _: 1 })) : i("", true), d(p).radio === 2 ? (t(), f(o, { key: 4, prop: "fixedPrice", label: "一口价", align: "center" })) : i("", true), c(o, { label: "操作", align: "center" }, { default: m(({ row: n }) => [N(c(s, { type: "primary", icon: "el-icon-edit", size: "default", onClick: (e) => B(n) }, null, 8, ["onClick"]), [[v, d(O).edit]]), c(V, { title: "确定删除本条数据吗?", onConfirm: (e) => j(n), "hide-icon": "" }, { reference: m(() => [N(c(s, { size: "default", type: "danger", icon: "el-icon-delete" }, null, 512), [[v, d(O).del]])]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data"]), c(ee, { "request-data": y, total: L.value, onHandleChange: g }, null, 8, ["request-data", "total"])]);
  };
} }, Me = Z(he, [["__scopeId", "data-v-58a8dc59"]]);
export {
  Me as default
};
