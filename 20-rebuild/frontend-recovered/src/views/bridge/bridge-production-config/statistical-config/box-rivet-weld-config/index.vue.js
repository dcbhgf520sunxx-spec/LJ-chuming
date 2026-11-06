import { ref as u } from "vue";
import { provide as p } from "vue";
import { onMounted as H } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as a } from "vue";
import { unref as s } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as P } from "vue";
import { withCtx as g } from "vue";
import { toDisplayString as w } from "vue";
import { Fragment as E } from "vue";
import { renderList as M } from "vue";
import { createCommentVNode as R } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as F } from "element-plus";
import { l, x as U, aZ as L, o as $, a9 as y, i as G, aT as K, G as Z, an as z } from "../../../../../shared/runtime.js";
import J from "./module/header.vue.js";
import X from "./module/batch-form.vue.js";
import Y from "./module/form.vue.js";
function ee(t) {
  return l({ module: "bridge", url: "rivetWeld/box/type", method: "get", params: t });
}
function te(t) {
  return l({ module: "bridge", url: "process/rivetWeld", method: "get", params: t });
}
function oe(t) {
  return l({ module: "bridge", url: "productProcess/box/list", method: "get", params: t });
}
function se(t) {
  return l({ module: "bridge", url: "rivetWeld", method: "get", params: t });
}
function re(t) {
  return l({ module: "bridge", url: "rivetWeld", method: "post", data: [t] });
}
function ie(t) {
  return l({ module: "bridge", url: "rivetWeld", method: "post", data: t });
}
function ae(t) {
  return l({ module: "bridge", url: "rivetWeld", method: "put", data: t });
}
function ne(t) {
  return l({ module: "bridge", url: "rivetWeld", method: "delete", data: t });
}
const ce = { get: se, del: ne, add: re, batchAdd: ie, edit: ae }, le = { class: "app-container" }, de = { class: "head-container" }, ue = { key: 0 }, pe = { key: 0 }, fe = { key: 1 }, _e = { __name: "index", setup(t) {
  const B = { batchAdd: true, add: true, edit: false, del: true, download: false }, j = u(), { crud: f, CRUD: N } = U({ title: "分段-组铆焊价格配置", sort: [], permission: { ...L }, optShow: { ...B }, crudApi: { ...ce }, hasPagination: false, requiredQuery: ["id"] }, j), { maxHeight: D } = $(), O = u([]), k = u({}), b = u([]), m = u({}), v = u([]), I = u({});
  p("rivetWeldList", O), p("rivetWeldListObj", k), p("artifactTypeList", b), p("artifactTypeListObj", m), p("processList", v), p("processListObj", I);
  async function A() {
    try {
      const o = await oe();
      b.value = o.map((r) => {
        r.specPrefixStr = r.specPrefixList.map((n) => n.specPrefix).join(" / ");
        const e = {}, d = [];
        if (r.productProcessLinkList) for (const n of r.productProcessLinkList) e[n.processId] = { processLinkId: n.id, processId: n.processId }, d.push(n.processId);
        return r.typeProcessObj = e, r.processIds = d, r;
      }), console.log(b.value), m.value = y(b.value, "id"), console.log(m.value);
    } catch (o) {
      console.log(o, "获取分段类型失败");
    }
    try {
      const { content: o } = await ee();
      O.value = o, k.value = y(o, "id");
    } catch (o) {
      console.log(o, "获取分段种类配置失败");
    }
    try {
      const o = await te();
      v.value = o, I.value = y(o, "id");
    } catch (o) {
      console.log(o, "获取所有工序失败");
    }
  }
  return H(() => {
    A();
  }), N.HOOK.handleRefresh = (o, r) => {
    r.data.content = r.data.content.map((e) => {
      var d;
      return e.specPrefixStr = e.crossSectionPrefix.join(" / "), e.needProcessIds = m.value[e.classificationId].processIds, e.processObj = ((d = e.structureProcessPriceList) == null ? void 0 : d.length) && y(e.structureProcessPriceList, "processId") || m.value[e.classificationId].typeProcessObj, e;
    });
  }, (o, r) => {
    const e = Q, d = V("common-table"), n = F;
    return c(), h("div", le, [_("div", de, [a(s(J))]), q((c(), P(d, { ref_key: "tableRef", ref: j, data: s(f).data, "empty-text": s(f).emptyText, "max-height": s(D), style: { width: "100%" }, "row-key": "id", onSelectionChange: s(f).selectionChangeHandler }, { default: g(() => [a(e, { type: "selection", width: "55", align: "center", fixed: "left" }), a(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(e, { prop: "classificationName", "show-overflow-tooltip": true, label: "分段类型", align: "center", "min-width": "200px", fixed: "left" }), a(e, { prop: "specPrefixStr", "show-overflow-tooltip": true, label: "截面前缀", align: "center", "min-width": "200px", fixed: "left" }), a(e, { "show-overflow-tooltip": true, label: "数值", align: "center", "min-width": "200px", fixed: "left" }, { default: g(({ row: i }) => [_("span", null, w(i.minNumerical), 1), r[0] || (r[0] = _("span", null, " ~ ", -1)), _("span", null, w(i.maxNumerical), 1)]), _: 1 }), a(e, { "show-overflow-tooltip": true, label: "工序单价（元）", align: "center", "min-width": "200px" }, { default: g(() => [(c(true), h(E, null, M(v.value, (i) => (c(), P(e, { key: i.id, "show-overflow-tooltip": true, align: "center", label: i.name, width: "120px" }, { default: g(({ row: { sourceRow: x } }) => {
      var W, C, T, S;
      return [((W = x.needProcessIds) == null ? void 0 : W.indexOf(i.id)) !== -1 ? (c(), h("span", ue, [s(G)((C = x.processObj[i.id]) == null ? void 0 : C.price) ? (c(), h("span", pe, w((T = x.processObj[i.id]) == null ? void 0 : T.price) + " " + w(s(K).V[(S = x.processObj[i.id]) == null ? void 0 : S.wageQuotaType].unit), 1)) : (c(), h("span", fe, "-"))])) : R("", true)];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }), a(e, { "min-width": "1px" }), s(Z)([...s(L).edit, ...s(L).del]) ? (c(), P(e, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: g(({ row: { sourceRow: i } }) => [a(s(z), { data: i }, null, 8, ["data"])]), _: 1 })) : R("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[n, s(f).loading]]), a(s(Y)), a(s(X), { currentType: s(f).query.id }, null, 8, ["currentType"])]);
  };
} };
export {
  _e as default
};
