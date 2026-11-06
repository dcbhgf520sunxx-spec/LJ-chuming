import { ref as u } from "vue";
import { provide as p } from "vue";
import { onMounted as H } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as m } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as a } from "vue";
import { unref as s } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as v } from "vue";
import { withCtx as h } from "vue";
import { toDisplayString as b } from "vue";
import { Fragment as E } from "vue";
import { renderList as M } from "vue";
import { createCommentVNode as R } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as F } from "element-plus";
import { l, x as U, pd as L, o as $, a9 as w, i as G, aT as K, G as z, an as J } from "../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
import Y from "./module/batch-form.vue.js";
import Z from "./module/form.vue.js";
function ee(t) {
  return l({ module: "mes", url: "rivetWeld/artifact/type/find", method: "get", params: t });
}
function te(t) {
  return l({ module: "mes", url: "process/rivetWeld", method: "get", params: t });
}
function oe(t) {
  return l({ module: "mes", url: "productProcess/artifact/list", method: "get", params: t });
}
function se(t) {
  return l({ module: "mes", url: "rivetWeld", method: "get", params: t });
}
function re(t) {
  return l({ module: "mes", url: "rivetWeld", method: "post", data: [t] });
}
function ie(t) {
  return l({ module: "mes", url: "rivetWeld", method: "post", data: t });
}
function ae(t) {
  return l({ module: "mes", url: "rivetWeld", method: "put", data: t });
}
function ne(t) {
  return l({ module: "mes", url: "rivetWeld", method: "delete", data: t });
}
const ce = { get: se, del: ne, add: re, batchAdd: ie, edit: ae }, le = { class: "app-container" }, de = { class: "head-container" }, ue = { key: 0 }, pe = { key: 0 }, fe = { key: 1 }, be = { __name: "index", setup(t) {
  const N = { batchAdd: true, add: true, edit: false, del: true, download: false }, j = u(), { crud: f, CRUD: A } = U({ title: "构件-组铆焊价格配置", sort: [], permission: { ...L }, optShow: { ...N }, crudApi: { ...ce }, hasPagination: false, requiredQuery: ["id"] }, j), { maxHeight: B } = $(), O = u([]), k = u({}), y = u([]), g = u({}), P = u([]), I = u({});
  p("rivetWeldList", O), p("rivetWeldListObj", k), p("artifactTypeList", y), p("artifactTypeListObj", g), p("processList", P), p("processListObj", I);
  async function D() {
    try {
      const o = await oe();
      y.value = o.map((r) => {
        r.specPrefixStr = r.specPrefixList.map((n) => n.specPrefix).join(" / ");
        const e = {}, d = [];
        if (r.productProcessLinkList) for (const n of r.productProcessLinkList) e[n.processId] = { processLinkId: n.id, processId: n.processId }, d.push(n.processId);
        return r.typeProcessObj = e, r.processIds = d, r;
      }), g.value = w(y.value, "id");
    } catch (o) {
      console.log(o, "获取构件类型失败");
    }
    try {
      const { content: o } = await ee();
      O.value = o, k.value = w(o, "id");
    } catch (o) {
      console.log(o, "获取构件种类配置失败");
    }
    try {
      const o = await te();
      P.value = o, I.value = w(o, "id");
    } catch (o) {
      console.log(o, "获取所有工序失败");
    }
  }
  return H(() => {
    D();
  }), A.HOOK.handleRefresh = (o, r) => {
    r.data.content = r.data.content.map((e) => {
      var d;
      return e.specPrefixStr = e.crossSectionPrefix.join(" / "), e.needProcessIds = g.value[e.classificationId].processIds, e.processObj = ((d = e.structureProcessPriceList) == null ? void 0 : d.length) && w(e.structureProcessPriceList, "processId") || g.value[e.classificationId].typeProcessObj, e;
    });
  }, (o, r) => {
    const e = Q, d = V("common-table"), n = F;
    return c(), m("div", le, [x("div", de, [a(s(X))]), q((c(), v(d, { ref_key: "tableRef", ref: j, data: s(f).data, "empty-text": s(f).emptyText, "max-height": s(B), style: { width: "100%" }, "row-key": "id", onSelectionChange: s(f).selectionChangeHandler }, { default: h(() => [a(e, { type: "selection", width: "55", align: "center", fixed: "left" }), a(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(e, { prop: "classificationName", "show-overflow-tooltip": true, label: "构件类型", align: "center", "min-width": "200px", fixed: "left" }), a(e, { prop: "specPrefixStr", "show-overflow-tooltip": true, label: "截面前缀", align: "center", "min-width": "200px", fixed: "left" }), a(e, { "show-overflow-tooltip": true, label: "构件截面", align: "center", "min-width": "200px", fixed: "left" }, { default: h(({ row: i }) => [x("span", null, b(i.minNumerical), 1), r[0] || (r[0] = x("span", null, " ~ ", -1)), x("span", null, b(i.maxNumerical), 1)]), _: 1 }), a(e, { "show-overflow-tooltip": true, label: "工序单价（元）", align: "center", "min-width": "200px" }, { default: h(() => [(c(true), m(E, null, M(P.value, (i) => (c(), v(e, { key: i.id, "show-overflow-tooltip": true, align: "center", label: i.name, width: "120px" }, { default: h(({ row: { sourceRow: _ } }) => {
      var W, C, T, S;
      return [((W = _.needProcessIds) == null ? void 0 : W.indexOf(i.id)) !== -1 ? (c(), m("span", ue, [s(G)((C = _.processObj[i.id]) == null ? void 0 : C.price) ? (c(), m("span", pe, b((T = _.processObj[i.id]) == null ? void 0 : T.price) + " " + b(s(K).V[(S = _.processObj[i.id]) == null ? void 0 : S.wageQuotaType].unit), 1)) : (c(), m("span", fe, "-"))])) : R("", true)];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }), a(e, { "min-width": "1px" }), s(z)([...s(L).edit, ...s(L).del]) ? (c(), v(e, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: h(({ row: { sourceRow: i } }) => [a(s(J), { data: i }, null, 8, ["data"])]), _: 1 })) : R("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[n, s(f).loading]]), a(s(Z)), a(s(Y), { currentType: s(f).query.id }, null, 8, ["currentType"])]);
  };
} };
export {
  be as default
};
