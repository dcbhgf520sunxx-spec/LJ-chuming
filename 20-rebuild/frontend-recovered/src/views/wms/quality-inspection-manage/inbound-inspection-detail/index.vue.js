import { ref as _ } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as S } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as l } from "vue";
import { withCtx as b } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElTag as P } from "element-plus";
import { vLoading as E } from "element-plus";
import { l as B, uv as D, x as j, Bx as A, o as V, cO as H, jl as I, By as N, jG as $, jH as L, k5 as M, k6 as O, P as U } from "../../../../shared/runtime.js";
import F from "./module/header.vue.js";
function G(f) {
  return B({ module: "wms", url: "inbound/application/record/quality-testing/detail", method: "get", params: f });
}
const K = { get: G }, z = { class: "app-container" }, X = { __name: "index", setup(f) {
  const x = { add: false, edit: false, del: false, download: false }, h = _(), T = _([...D, ["project", ["parse-project", { onlyShortName: true }]], ["approvalComments", "empty-text"]]), { crud: c, columns: o, CRUD: k } = j({ title: "入库质检明细", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime", "licensePlate", "shipmentNumber"], permission: { ...A }, optShow: { ...x }, crudApi: { ...K } }, h), { maxHeight: C } = V({ paginate: true });
  return k.HOOK.handleRefresh = async (R, { data: r }) => {
    await H(r.content), r.content = await I(r.content, { toSmallest: false, toNum: false }), r.content = r.content.map((e) => {
      var u, p, m, d, i;
      return e.createTime = (u = e.inboundReceipt) == null ? void 0 : u.createTime, e.supplier = (p = e.inboundReceipt) == null ? void 0 : p.supplier, e.licensePlate = (m = e.inboundReceipt) == null ? void 0 : m.licensePlate, e.shipmentNumber = (d = e.inboundReceipt) == null ? void 0 : d.shipmentNumber, e.purchaseSN = (i = e.inboundReceipt) == null ? void 0 : i.purchaseSN, e.spec = e.specification, e;
    });
  }, (R, r) => {
    const e = q, u = P, p = w("table-cell-tag"), m = w("common-table"), d = E;
    return a(), S("div", z, [s(t(F)), v((a(), l(m, { ref_key: "tableRef", ref: h, data: t(c).data, "data-format": T.value, "max-height": t(C), "default-expand-all": false, "row-key": "id" }, { default: b(() => [s(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), t(o).visible("qualityTestingEnum") ? (a(), l(e, { key: "qualityTestingEnum", "show-overflow-tooltip": true, prop: "qualityTestingEnum", label: "状态", align: "center", width: "80", fixed: "left" }, { default: b(({ row: i }) => [s(u, { type: t(N).V[i.qualityTestingEnum].TAG }, { default: b(() => [y(g(t(N).V[i.qualityTestingEnum].L), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : n("", true), t(o).visible("createTime") ? (a(), l(e, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请时间", align: "center", width: "140" })) : n("", true), s($, { showIndex: false, "basic-class": t(c).query.basicClass }, null, 8, ["basic-class"]), s(L, { "basic-class": t(c).query.basicClass }, null, 8, ["basic-class"]), s(M, { "basic-class": t(c).query.basicClass }, null, 8, ["basic-class"]), s(O, { "show-project": "" }), t(o).visible("purchaseSN") ? (a(), l(e, { key: "purchaseSN", "show-overflow-tooltip": true, prop: "purchaseSN", label: "采购单号", "min-width": "155" }, { default: b(({ row: i }) => [s(p, { show: !!i.boolPartyA, name: "甲供", type: "partyA", offset: 10 }, null, 8, ["show"]), y(" " + g(i.purchaseSN), 1)]), _: 1 })) : n("", true), t(o).visible("inboundReceipt.serialNumber") ? (a(), l(e, { key: "inboundReceipt.serialNumber", "show-overflow-tooltip": true, prop: "inboundReceipt.serialNumber", "min-width": "160", label: "入库单号", align: "left" })) : n("", true), t(o).visible("licensePlate") ? (a(), l(e, { key: "licensePlate", "show-overflow-tooltip": true, prop: "licensePlate", label: "车牌/船牌号", align: "left", width: "100" })) : n("", true), t(o).visible("shipmentNumber") ? (a(), l(e, { key: "shipmentNumber", prop: "shipmentNumber", label: "物流单号", align: "left", "min-width": "150", "show-overflow-tooltip": "" })) : n("", true), t(o).visible("supplier.name") ? (a(), l(e, { key: "supplier.name", "show-overflow-tooltip": true, prop: "supplier.name", label: "供应商", "min-width": "200" })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[d, t(c).loading]]), s(t(U))]);
  };
} };
export {
  X as default
};
