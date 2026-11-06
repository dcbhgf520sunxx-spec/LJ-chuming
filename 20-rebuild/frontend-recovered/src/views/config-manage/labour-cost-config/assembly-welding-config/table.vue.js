import { ref as h } from "vue";
import { inject as I } from "vue";
import { reactive as q } from "vue";
import { computed as N } from "vue";
import { onMounted as W } from "vue";
import { watch as X } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as l } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as O } from "vue";
import { toDisplayString as o } from "vue";
import { Fragment as d } from "vue";
import { renderList as y } from "vue";
import { unref as r } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as s } from "vue";
import { withDirectives as D } from "vue";
import { nextTick as Y } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElButton as H } from "element-plus";
import { ElPopconfirm as J } from "element-plus";
import { ElTable as K } from "element-plus";
import { j as Q, k as U, l as Z, m as ee } from "../../../../modules/project-assembly-welding-config-107f9ee1.js";
import { _ as te, e0 as L, e1 as v, bV as x, ea as T, eb as ae, G as ne, e2 as M, ec as oe } from "../../../../shared/runtime.js";
const se = { class: "table-container" }, re = { key: 1 }, ie = { key: 0 }, ce = { key: 1, class: "direction" }, le = { key: 2, class: "direction" }, pe = { key: 3 }, de = { key: 1 }, ue = { key: 0 }, _e = { key: 1, class: "direction" }, me = { key: 2, class: "direction" }, ye = { key: 3 }, ge = { key: 1 }, fe = { key: 0 }, be = { key: 1, class: "direction" }, ke = { key: 2, class: "direction" }, Oe = { key: 3 }, he = { key: 1 }, Le = { key: 0, class: "price-text" }, ve = { key: 1 }, Te = { key: 0 }, Pe = { key: 1 }, we = { key: 0, class: "price-text" }, Ce = { key: 1 }, ze = { key: 0 }, Ie = { key: 1 }, Ne = { __name: "table", setup(De, { expose: E }) {
  const P = h(false), b = I("projectData"), S = I("parentData"), { headerRef: u } = S, w = h([]), k = q({ pageSize: 10, pageNumber: 1, sort: "id.asc" }), C = h(0), V = N(() => b ? Q : U), j = N(() => b ? Z : ee), f = async () => {
    if (!ne(T.get)) return M("warning", "暂无权限");
    try {
      P.value = true;
      const { content: _, totalElements: m } = await V.value({ ...k, projectId: b ? b.contractProjectId : null });
      C.value = m;
      const i = _.map((c) => ({ id: c.id, artifactTypeId: c.artifactTypeId, artifactTypeName: c.artifactTypeName, artifactNameList: c.artifactNameList, processList: c.processList, measurementManner: c.measurementManner, organizationInsidePrice: c.organizationInsidePrice, organizationOutsidePrice: c.organizationOutsidePrice }));
      w.value = oe(i);
    } catch (_) {
      console.error("获取装焊配置失败;" + _);
    } finally {
      P.value = false;
    }
  }, B = async (_) => {
    try {
      await j.value(_.id), M("success", "删除成功"), f();
    } catch (m) {
      console.log(m);
    }
  }, A = async (_) => {
    Object.assign(u.value.createRef.calculationFormData, { id: _.id }), u.value.createRef.visible = true, Y(() => {
      u.value.createRef.currentComponentRef.getDrillConfigInfo();
    });
  };
  return W(() => {
    f();
  }), X(() => u.value.radio, (_) => {
    _ && (k.pageNumber = 1, k.pageSize = 10), f();
  }), E({ getSparePartsConfigList: f }), (_, m) => {
    const i = G, c = H, R = J, $ = K, z = F("permission");
    return t(), a("div", se, [l($, { data: w.value, border: "", fit: "" }, { default: p(() => [l(i, { align: "center", label: "序号", type: "index", width: "55" }), l(i, { align: "center", label: "构件类型", prop: "artifactTypeName", "show-overflow-tooltip": "" }, { default: p(({ row: n }) => [O("span", null, o(`【 ${n.artifactTypeName} 】`), 1)]), _: 1 }), l(i, { align: "center", label: "构件名称", prop: "artifactNameList", "show-overflow-tooltip": "" }, { default: p(({ row: n }) => [(t(true), a(d, null, y(n.artifactNameList, (e) => (t(), a("span", null, o(`【 ${e} 】`), 1))), 256))]), _: 1 }), l(i, { align: "center", label: "生产工序", "min-width": "140", "show-overflow-tooltip": "" }, { default: p(({ row: n }) => [n.processList.length ? (t(true), a(d, { key: 0 }, y(n.processList, (e) => (t(), a("span", { key: e }, o(`【 ${e.name} 】`), 1))), 128)) : (t(), a("span", re, "-"))]), _: 1 }), l(i, { align: "center", label: "计量方式", prop: "measurementMannerName" }), r(u).radio !== 2 ? (t(), g(i, { key: 0, align: "center", class: "mm-container", label: "牛腿数" }, { default: p(({ row: n }) => [n.pricingManner === 1 ? (t(true), a(d, { key: 0 }, y(n.detailList, (e) => (t(), a("div", { key: e, class: "detailList-container" }, [e.numberOne && e.comparisonOperatorOne ? (t(), a("span", ie, o(e.numberOne), 1)) : s("", true), e.numberOne && e.comparisonOperatorOne ? (t(), a("span", ce, o(r(L).V[e.comparisonOperatorOne].L), 1)) : s("", true), m[0] || (m[0] = O("span", null, "X", -1)), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", le, o(r(v).V[e.comparisonOperatorTwo].L), 1)) : s("", true), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", pe, o(e.numberTwo), 1)) : s("", true)]))), 128)) : (t(), a("span", de, "-"))]), _: 1 })) : s("", true), r(u).radio !== 2 ? (t(), g(i, { key: 1, align: "center", class: "mm-container", label: "构零件比" }, { default: p(({ row: n }) => [n.pricingManner === 2 ? (t(true), a(d, { key: 0 }, y(n.detailList, (e) => (t(), a("div", { key: e, class: "detailList-container" }, [e.numberOne && e.comparisonOperatorOne ? (t(), a("span", ue, o(e.numberOne), 1)) : s("", true), e.numberOne && e.comparisonOperatorOne ? (t(), a("span", _e, o(r(L).V[e.comparisonOperatorOne].L), 1)) : s("", true), m[1] || (m[1] = O("span", null, "X", -1)), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", me, o(r(v).V[e.comparisonOperatorTwo].L), 1)) : s("", true), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", ye, o(e.numberTwo), 1)) : s("", true)]))), 128)) : (t(), a("span", ge, "-"))]), _: 1 })) : s("", true), r(u).radio !== 2 ? (t(), g(i, { key: 2, align: "center", class: "mm-container", label: "构件截面" }, { default: p(({ row: n }) => [n.pricingManner === 3 ? (t(true), a(d, { key: 0 }, y(n.detailList, (e) => (t(), a("div", { key: e, class: "detailList-container" }, [e.numberOne && e.comparisonOperatorOne ? (t(), a("span", fe, o(e.numberOne), 1)) : s("", true), e.numberOne && e.comparisonOperatorOne ? (t(), a("span", be, o(r(L).V[e.comparisonOperatorOne].L), 1)) : s("", true), m[2] || (m[2] = O("span", null, "X", -1)), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", ke, o(r(v).V[e.comparisonOperatorTwo].L), 1)) : s("", true), e.numberTwo && e.comparisonOperatorTwo ? (t(), a("span", Oe, o(e.numberTwo), 1)) : s("", true)]))), 128)) : (t(), a("span", he, "-"))]), _: 1 })) : s("", true), r(u).radio !== 2 ? (t(), g(i, { key: 3, align: "right", label: "编制内单价（元）" }, { default: p(({ row: n }) => [n.detailList ? (t(true), a(d, { key: 0 }, y(n.detailList, (e) => (t(), a(d, { key: e.id }, [e.organizationInsidePrice ? (t(), a("div", Le, o(r(x)(e.organizationInsidePrice)), 1)) : (t(), a("span", ve, "-"))], 64))), 128)) : (t(), a(d, { key: 1 }, [n.organizationInsidePrice ? (t(), a("span", Te, o(n.organizationInsidePrice), 1)) : (t(), a("span", Pe, "-"))], 64))]), _: 1 })) : s("", true), r(u).radio !== 2 ? (t(), g(i, { key: 4, align: "right", label: "编制外单价（元）" }, { default: p(({ row: n }) => [n.detailList ? (t(true), a(d, { key: 0 }, y(n.detailList, (e) => (t(), a(d, { key: e.id }, [e.organizationOutsidePrice ? (t(), a("div", we, o(r(x)(e.organizationOutsidePrice)), 1)) : (t(), a("span", Ce, "-"))], 64))), 128)) : (t(), a(d, { key: 1 }, [n.organizationOutsidePrice ? (t(), a("span", ze, o(n.organizationOutsidePrice), 1)) : (t(), a("span", Ie, "-"))], 64))]), _: 1 })) : s("", true), r(u).radio === 2 ? (t(), g(i, { key: 5, align: "center", label: "一口价", prop: "fixedPrice" })) : s("", true), l(i, { align: "center", label: "操作", width: "120" }, { default: p(({ row: n }) => [D(l(c, { icon: "el-icon-edit", size: "default", type: "primary", onClick: (e) => A(n) }, null, 8, ["onClick"]), [[z, r(T).edit]]), l(R, { "hide-icon": "", title: "确定删除本条数据吗?", onConfirm: (e) => B(n) }, { reference: p(() => [D(l(c, { icon: "el-icon-delete", size: "default", type: "danger" }, null, 512), [[z, r(T).del]])]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data"]), l(ae, { "request-data": k, total: C.value, onHandleChange: f }, null, 8, ["request-data", "total"])]);
  };
} }, Se = te(Ne, [["__scopeId", "data-v-65c2bdec"]]);
export {
  Se as default
};
