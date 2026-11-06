import { inject as R } from "vue";
import { ref as T } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as u } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as V } from "vue";
import { createTextVNode as W } from "vue";
import { createCommentVNode as B } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as H } from "element-plus";
import { t as I } from "../../../../../modules/wage-adjust-5476478d.js";
import { x as O, o as P, c as S, D as U, a3 as $, G as j } from "../../../../../shared/runtime.js";
import G from "./module/header.vue.js";
const L = { class: "app-container" }, M = { class: "head-container" }, Q = { __name: "index", emits: ["setInfo"], setup(z, { expose: h, emit: g }) {
  const x = { add: false, edit: false, del: false, download: false }, d = g, m = R("permission"), p = T(), { crud: o, CRUD: y } = O({ title: "工价调整汇总", permission: { ...m }, optShow: { ...x }, crudApi: { get: I }, sort: [], hasPagination: false }, p), { maxHeight: b } = P({ paginate: false });
  y.HOOK.handleRefresh = (n, { data: s }) => {
    s.content.forEach((t) => {
      t.netWeight = S(t.netWeight, "kg", "t", U.COM_WT__T);
    });
  };
  function w(n) {
    d("setInfo", n);
  }
  function C(n) {
    d("setInfo", n);
  }
  return h({ query: o.query }), (n, s) => {
    const t = N, k = _("common-button"), v = _("common-table"), D = H;
    return r(), E("div", L, [f("div", M, [a(e(G))]), q((r(), u(v, { ref_key: "tableRef", ref: p, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(b), style: { width: "100%" }, onRowClick: C }, { default: i(() => [a(t, { label: "序号", type: "index", align: "center", width: "60" }), a(t, { "show-overflow-tooltip": "", label: `${e($).VL[e(o).query.taskTypeEnum]}类型`, prop: "productClass.name", align: "center" }, null, 8, ["label"]), a(t, { label: "数量（件）", prop: "quantity", width: "110", align: "center" }), a(t, { label: "重量（吨）", prop: "netWeight", width: "110", align: "center" }, { default: i(({ row: l }) => {
      var c;
      return [f("span", null, V((c = l.netWeight) == null ? void 0 : c.toFixed(2)), 1)];
    }), _: 1 }), e(j)(e(m).edit) ? (r(), u(t, { key: 0, align: "center", prop: "prop", label: "操作", width: "100" }, { default: i(({ row: l }) => [a(k, { type: "warning", size: "default", onClick: (c) => w(l) }, { default: i(() => s[0] || (s[0] = [W("修改")])), _: 2, __: [0] }, 1032, ["onClick"])]), _: 1 })) : B("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[D, e(o).loading]])]);
  };
} };
export {
  Q as default
};
