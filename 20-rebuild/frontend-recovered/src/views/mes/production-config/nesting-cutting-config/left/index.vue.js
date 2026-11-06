import { ref as u } from "vue";
import { watch as R } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as i } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as H } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElCard as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as V } from "../../../../../modules/nesting-cutting-config-6d0e9e39.js";
import { x as E, oX as m, o as A, au as K, G as M, an as T, P as U } from "../../../../../shared/runtime.js";
import $ from "./module/header.vue.js";
import q from "./module/form.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const F = { class: "head-container" }, Y = { __name: "index", props: { isRefresh: { type: Boolean, default: false } }, emits: ["list"], setup(f, { emit: _ }) {
  const w = _, g = f, x = [], b = { add: true, edit: false, del: false, download: false }, c = u(), k = u([]), { crud: r, CRUD: h } = E({ title: "班组代号", sort: [], optShow: { ...b }, permission: { ...m }, crudApi: { ...V } }, c), { maxHeight: y } = A({ wrapperBox: [".app-container"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  return R(() => g.isRefresh, () => {
    r.toQuery();
  }), h.HOOK.handleRefresh = (C, l) => {
    w("list", l.data.content);
  }, h.HOOK.afterRefresh = () => {
    console.log("crud.data:", r.data);
  }, (C, l) => {
    const t = L, N = B("common-table"), S = O, v = P;
    return i(), d(S, null, { header: n(() => l[0] || (l[0] = [s("span", null, "班组代号配置", -1)])), default: n(() => [s("div", F, [a(e($), { workShopList: k.value }, null, 8, ["workShopList"])]), D((i(), d(N, { ref_key: "tableRef", ref: c, data: e(r).data, "data-format": x, "empty-text": e(r).emptyText, "max-height": e(y), style: { width: "100%" }, "row-key": "id" }, { default: n(() => [a(t, { label: "序号", type: "index", align: "center", width: "60" }), a(t, { key: "workshopName", prop: "workshopName", "show-overflow-tooltip": true, label: "车间", "min-width": "100px", align: "center" }, { default: n(({ row: o }) => [s("span", null, p(o.workshopName), 1)]), _: 1 }), a(t, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "工序", "min-width": "100px", align: "center" }, { default: n(({ row: o }) => [s("span", null, p(o.processName), 1)]), _: 1 }), a(t, { key: "teamName", prop: "teamName", label: "班组", align: "center" }), a(t, { key: "codeName", prop: "codeName", label: "代号", align: "center" }), a(t, { key: "boolShowCodename", prop: "boolShowCodename", label: "是否显示代号", align: "center" }, { default: n(({ row: o }) => [s("span", null, p(e(K).VL[o.boolShowCodename] || "-"), 1)]), _: 1 }), e(M)([...e(m).edit, ...e(m).del]) ? (i(), d(t, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n((o) => [a(e(T), { data: o.row }, null, 8, ["data"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, e(r).loading]]), a(e(U)), a(e(q))]), _: 1 });
  };
} };
export {
  Y as default
};
