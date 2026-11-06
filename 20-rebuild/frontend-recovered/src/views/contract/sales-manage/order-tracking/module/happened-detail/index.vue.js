import { inject as N } from "vue";
import { watch as T } from "vue";
import { nextTick as C } from "vue";
import { ref as R } from "vue";
import { computed as j } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as a } from "vue";
import { withCtx as b } from "vue";
import { createTextVNode as F } from "vue";
import { toDisplayString as I } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as B } from "element-plus";
import { s as E } from "../../../../../../modules/order-tracking-9be524cd.js";
import { M as H } from "../../../../../../modules/contract-9b18cc88.js";
import { t as V, x as A, o as O, P as U } from "../../../../../../shared/runtime.js";
import K from "./module/header.vue.js";
const L = { class: "app-container" }, X = { __name: "index", setup(Q) {
  const v = N("projectId"), { decimalPrecision: c } = V();
  T(v, (s) => {
    C(() => {
      r.query.projectId = s, r.refresh();
    });
  }, { immediate: true });
  const _ = { add: false, edit: false, del: false, download: false }, m = R(), g = j(() => [["auditTime", "parse-time"], ["unitPrice", ["to-thousand", c.value.contract]], ["totalPrice", ["to-thousand", c.value.contract]]]), { crud: r, columns: i, CRUD: y } = A({ title: "发运记录", sort: [], permission: { get: H.detail }, crudApi: { get: E }, requiredQuery: ["projectId"], optShow: { ..._ } }, m), { maxHeight: k } = O({ paginate: true });
  return y.HOOK.handleRefresh = async (s, { data: p }) => {
    p.content.forEach((e) => {
      e.totalMete && (e.totalMete = Number(e.totalMete.toFixed(2)) ? e.totalMete.toFixed(2) : Number(e.totalMete.toFixed(5)));
    });
  }, (s, p) => {
    const e = S, x = h("table-cell-tag"), P = h("common-table"), M = q("empty-text"), D = B;
    return o(), w("div", L, [n(t(K)), f((o(), a(P, { ref_key: "tableRef", ref: m, "data-format": g.value, data: t(r).data, style: { width: "100%" }, "max-height": t(k) }, { default: b(() => [n(e, { label: "序号", type: "index", align: "center", width: "60" }), t(i).visible("monomer.name") ? (o(), a(e, { key: "monomer.name", prop: "monomer.name", label: "单体", "min-width": "140", "show-overflow-tooltip": "" }, { default: b(({ row: d }) => {
      var u;
      return [n(x, { show: d.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), f((o(), w("span", null, [F(I((u = d.monomer) == null ? void 0 : u.name), 1)])), [[M]])];
    }), _: 1 })) : l("", true), t(i).visible("area.name") ? (o(), a(e, { prop: "area.name", key: "area.name", label: "区域", "min-width": "140", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("name") ? (o(), a(e, { prop: "name", key: "name", label: "名称", align: "center", "min-width": "110", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("serialNumber") ? (o(), a(e, { prop: "serialNumber", key: "serialNumber", label: "编号", align: "center", "min-width": "110", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("specification") ? (o(), a(e, { prop: "specification", key: "specification", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("material") ? (o(), a(e, { prop: "material", key: "material", label: "材质", align: "center", "min-width": "100", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("measure") ? (o(), a(e, { prop: "measure", key: "measure", label: "计量单位", align: "center", width: "70", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("quantity") ? (o(), a(e, { prop: "quantity", key: "quantity", label: "数量", align: "center", "min-width": "60", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("nuclear") ? (o(), a(e, { prop: "nuclear", key: "nuclear", label: "核算单位", align: "center", width: "70", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("totalMete") ? (o(), a(e, { prop: "totalMete", key: "totalMete", label: "总量", align: "center", "min-width": "100", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("unitPrice") ? (o(), a(e, { prop: "unitPrice", key: "unitPrice", label: "单价", align: "right", "min-width": "80", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("totalPrice") ? (o(), a(e, { prop: "totalPrice", key: "totalPrice", label: "总价", align: "right", "min-width": "100", "show-overflow-tooltip": "" })) : l("", true), t(i).visible("auditTime") ? (o(), a(e, { prop: "auditTime", key: "auditTime", label: "发运时间", align: "center", width: "130", "show-overflow-tooltip": "" })) : l("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[D, t(r).loading]]), n(t(U))]);
  };
} };
export {
  X as default
};
