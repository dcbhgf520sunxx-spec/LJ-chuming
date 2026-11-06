import { ref as h } from "vue";
import { inject as W } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as b } from "vue";
import { createBlock as k } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as l } from "vue";
import { createElementVNode as r } from "vue";
import { unref as i } from "vue";
import { withDirectives as D } from "vue";
import { isRef as Q } from "vue";
import { ElTag as E } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { g as z } from "../../../../../modules/personal-production-statistics-348e794f.js";
import { u as U, x as A, o as M, P as K } from "../../../../../shared/runtime.js";
import L from "./module/header.vue.js";
const S = { class: "head-container" }, X = { __name: "index", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(u, { emit: x }) {
  const N = x, d = u, { visible: m, handleClose: I } = U({ emit: N, props: d, showHook: j }), q = h(), T = W("query"), g = h(), { crud: n, CRUD: V } = A({ title: "个人产量统计-详情", sort: [], crudApi: { get: z }, hasPagination: true, queryOnPresenterCreated: false }, q);
  V.HOOK.beforeToQuery = () => {
    var f, s, p, a;
    n.query.projectId = (s = (f = d.detailInfo) == null ? void 0 : f.project) == null ? void 0 : s.id, n.query.monomerId = (a = (p = d.detailInfo) == null ? void 0 : p.monomer) == null ? void 0 : a.id, n.query.taskTypeEnum = T.taskTypeEnum, n.query.userId = d.detailInfo.userId;
  };
  const { maxHeight: C } = M({ mainBox: ".personal-production-statistics-detail", extraBox: [".head-container", ".el-drawer__header"], wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, paginate: true }, () => g.value.loaded);
  function j() {
    n.toQuery();
  }
  return (f, s) => {
    const p = E, a = O, B = y("common-table"), R = y("common-drawer"), H = P;
    return b(), k(R, { ref_key: "drawerRef", ref: g, title: "上报明细", "close-on-click-modal": false, modelValue: i(m), "onUpdate:modelValue": s[0] || (s[0] = (e) => Q(m) ? m.value = e : null), "before-close": i(I), size: "80%", "custom-class": "personal-production-statistics-detail" }, { titleAfter: o(() => [t(p, { effect: "plain", size: "large" }, { default: o(() => {
      var e, c, w, _;
      return [v("项目：" + l((c = (e = u.detailInfo) == null ? void 0 : e.project) == null ? void 0 : c.serialNumber) + " - " + l((_ = (w = u.detailInfo) == null ? void 0 : w.project) == null ? void 0 : _.shortName), 1)];
    }), _: 1 }), t(p, { effect: "plain", size: "large" }, { default: o(() => {
      var e, c;
      return [v("单体：" + l(((c = (e = u.detailInfo) == null ? void 0 : e.monomer) == null ? void 0 : c.name) || "-"), 1)];
    }), _: 1 })]), content: o(() => [r("div", S, [t(i(L))]), D((b(), k(B, { data: i(n).data, "max-height": i(C) }, { default: o(() => [t(a, { label: "序号", key: "index", type: "index", align: "center", width: "60" }), t(a, { key: "name", prop: "name", label: "构件名称", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.name || "-"), 1)]), _: 1 }), t(a, { key: "serialNumber", prop: "serialNumber", label: "构件编号", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.serialNumber || "-"), 1)]), _: 1 }), t(a, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.specification || "-"), 1)]), _: 1 }), t(a, { key: "length", prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.length ?? "-"), 1)]), _: 1 }), t(a, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.netWeight ?? "-"), 1)]), _: 1 }), t(a, { key: "processName", prop: "processName", label: "工序", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.processName || "-"), 1)]), _: 1 }), t(a, { key: "reportQuantity", prop: "reportQuantity", label: "上报量", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.reportQuantity ?? "-"), 1)]), _: 1 }), t(a, { key: "reportWeight", prop: "reportWeight", label: "上报总净重（kg）", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.reportWeight ?? "-"), 1)]), _: 1 }), t(a, { key: "userName", prop: "userName", label: "上报人", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.userName || "-"), 1)]), _: 1 }), t(a, { key: "reportTime", prop: "reportTime", label: "上报时间", align: "center", "show-overflow-tooltip": "" }, { default: o((e) => [r("span", null, l(e.row.reportTime || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[H, i(n).loading]]), t(i(K))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  X as default
};
