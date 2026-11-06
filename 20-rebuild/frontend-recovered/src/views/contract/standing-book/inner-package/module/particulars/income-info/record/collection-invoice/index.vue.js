import { _ as N, i as j, bV as k, j0 as b } from "../../../../../../../../../shared/runtime.js";
import { ref as C } from "vue";
import { computed as u } from "vue";
import { inject as D } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as r } from "vue";
import { unref as p } from "vue";
import { createBlock as B } from "vue";
import { resolveDynamicComponent as P } from "vue";
import { createTextVNode as S } from "vue";
import { createCommentVNode as w } from "vue";
import { Fragment as L } from "vue";
import { defineAsyncComponent as g } from "vue";
import { ElCol as O } from "element-plus";
import { ElRow as $ } from "element-plus";
import { ElTag as z } from "element-plus";
const F = { class: "endLog-table-container" }, M = { key: 1 }, q = { key: 0 }, G = { __name: "index", setup(H, { expose: x }) {
  const m = C(null), y = { collection: g(() => b(() => import("./CollectionTable.vue.js"), ["static/js/CollectionTable-2a13e0dd.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/upload-file-download-812f558c.js", "static/js/useTableTotal-3d22365a.js", "static/js/useTableHeight-90797a0b.js", "static/css/CollectionTable-0a3d5458.css"])), invoice: g(() => b(() => import("./InvoiceTable.vue.js"), ["static/js/InvoiceTable-a1a43514.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/upload-file-download-812f558c.js", "static/js/useTableTotal-3d22365a.js", "static/js/useTableHeight-90797a0b.js", "static/css/InvoiceTable-a41fedd8.css"])) }, l = C(""), A = u(() => y[l.value]), { _commonAttribute: d } = D("parent_data");
  d.value.isShowPrintTable = u(() => j(l.value));
  const { endLogTableData: E, projectInfo: T } = D("info_parent_data"), i = u(() => E.collectionDetailsDto), v = (f) => {
    l.value = f;
  };
  return d.value.isInfoPrintType = l, x({ currentComponentRef: m }), (f, e) => {
    const o = O, R = $, V = z;
    return c(), _(L, null, [s("div", F, [t(R, null, { default: a(() => [t(o, { span: 2, class: "col-container center" }, { default: a(() => e[2] || (e[2] = [s("span", { class: "item-label" }, "累计收款", -1)])), _: 1, __: [2] }), t(o, { span: 4, class: "col-container value-col look" }, { default: a(() => {
      var n;
      return [s("span", { onClick: e[0] || (e[0] = (I) => v("collection")) }, r(p(k)((n = i.value) == null ? void 0 : n.contractAmountSum)), 1)];
    }), _: 1 }), t(o, { span: 2, class: "col-container center" }, { default: a(() => e[3] || (e[3] = [s("span", { class: "item-label" }, "收款率", -1)])), _: 1, __: [3] }), t(o, { span: 4, class: "col-container value-col" }, { default: a(() => {
      var n;
      return [s("span", null, r((n = i.value) == null ? void 0 : n.contractAmountRate) + "%", 1)];
    }), _: 1 }), t(o, { span: 2, class: "col-container center" }, { default: a(() => e[4] || (e[4] = [s("span", { class: "item-label" }, "累计开票", -1)])), _: 1, __: [4] }), t(o, { span: 4, class: "col-container value-col look" }, { default: a(() => {
      var n;
      return [p(T).projectManagerName ? (c(), _("span", { key: 0, onClick: e[1] || (e[1] = (I) => v("invoice")) }, r(p(k)((n = i.value) == null ? void 0 : n.invoiceAmountSum)), 1)) : (c(), _("span", M, "-"))];
    }), _: 1 }), t(o, { span: 2, class: "col-container center" }, { default: a(() => e[5] || (e[5] = [s("span", { class: "item-label" }, "开票率", -1)])), _: 1, __: [5] }), t(o, { span: 4, class: "col-container value-col" }, { default: a(() => {
      var n;
      return [s("span", null, r((n = i.value) == null ? void 0 : n.invoiceAmountRate) + "%", 1)];
    }), _: 1 })]), _: 1 })]), (c(), B(P(A.value), { ref_key: "currentComponentRef", ref: m, class: "animate__animated animate__fadeIn animate__faster" }, null, 512)), l.value ? w("", true) : (c(), _("div", q, [t(V, { size: "large" }, { default: a(() => e[6] || (e[6] = [S("* 点击累计收款与开票可查看详细记录")])), _: 1, __: [6] })]))], 64);
  };
} }, Q = N(G, [["__scopeId", "data-v-630e4e4c"]]);
export {
  Q as default
};
