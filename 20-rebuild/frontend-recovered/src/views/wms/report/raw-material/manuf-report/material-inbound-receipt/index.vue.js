import { ref as m } from "vue";
import { computed as S } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as o } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as j } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as V } from "vue";
import { ElTableColumn as E } from "element-plus";
import { vLoading as A } from "element-plus";
import { b as D, a as M } from "../../../../../../modules/manuf-inbound-dfa0968a.js";
import { Bu as U, cP as B, x as F, BV as g, o as O, G as H, aR as I, ux as K, an as $, P as q } from "../../../../../../shared/runtime.js";
import L from "./module/header.vue.js";
import Y from "./module/detail.vue.js";
import "../../../../../../modules/inbound-9bad80c1.js";
const G = { class: "app-container" }, te = { __name: "index", setup(Q) {
  const v = { add: false, edit: false, del: false, download: false }, N = m([...U, ["inboundTime", "parse-time"], ["rejectAmountExcludingVATNoFreight", ["to-thousand-ck", "YUAN"]], ["amountExcludingVat", ["to-thousand-ck", "YUAN"]], ["projects", ["parse-project", { onlyShortName: true }]], ["projectsFullName", "parse-project", { source: "projects" }], ["basicClass", ["parse-enum", B, { bit: true, split: " | " }]]]), c = m([]), h = m(), { crud: p, CRUD: y, columns: r } = F({ title: "制成品入库记录", sort: ["id.desc"], invisibleColumns: ["rejectAmountExcludingVATNoFreight", "editorName", "userUpdateTime", "createTime", "reviewPassTime", "licensePlate", "shipmentNumber"], permission: { ...g }, requiredQuery: ["projectId"], optShow: { ...v }, crudApi: { get: D, detail: M } }, h), { maxHeight: k } = O({ paginate: true });
  y.HOOK.handleRefresh = async (_, { data: n }) => {
    n.content.forEach((t) => {
      t.purchaseOrder = { id: t.purchaseId, serialNumber: t.purchaseSN };
    });
  };
  const x = S(() => H(g.showAmount));
  return (_, n) => {
    const t = E, C = T("common-table"), R = A;
    return a(), f("div", G, [s(e(L)), P((a(), o(C, { ref_key: "tableRef", ref: h, data: e(p).data, "data-format": N.value, "default-expand-all": false, "expand-row-keys": c.value, "max-height": e(k), "highlight-current-row": "", "row-key": "id", onSortChange: e(p).handleSortChange, onSelectionChange: e(p).selectionChangeHandler }, { default: u(() => [s(I, { "expand-row-keys": c.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (l) => c.value = l), data: e(p).data, "row-key": "id" }, { default: u(({ row: l }) => [d("p", null, [n[1] || (n[1] = j(" 关联项目：")), d("span", null, b(l.projectsFullName), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(t, { align: "center", type: "selection", width: "55" }), s(t, { align: "center", label: "序号", type: "index", width: "60" }), e(r).visible("purchaseSN") ? (a(), o(t, { key: "purchaseSN", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseSN" }, { default: u(({ row: { sourceRow: l } }) => {
      var w;
      return [(w = l.purchaseOrder) != null && w.id ? (a(), o(e(K), { key: 0, receipt: l.purchaseOrder, "receipt-types": ["PURCHASE"] }, null, 8, ["receipt"])) : i("", true)];
    }), _: 1 })) : i("", true), e(r).visible("serialNumber") ? (a(), o(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "160", prop: "serialNumber" }, { default: u(({ row: { sourceRow: l } }) => [d("span", null, b(l.serialNumber), 1)]), _: 1 })) : i("", true), e(r).visible("licensePlate") ? (a(), o(t, { key: "licensePlate", "show-overflow-tooltip": true, align: "left", label: "车牌/船牌号", prop: "licensePlate", width: "100" })) : i("", true), e(r).visible("shipmentNumber") ? (a(), o(t, { key: "shipmentNumber", align: "left", label: "物流单号", "min-width": "150", prop: "shipmentNumber", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("basicClass") ? (a(), o(t, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "120" })) : i("", true), e(r).visible("projects") ? (a(), o(t, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("supplier.name") ? (a(), o(t, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : i("", true), x.value ? (a(), f(V, { key: 7 }, [e(r).visible("amountExcludingVat") ? (a(), o(t, { key: "amountExcludingVat", "show-overflow-tooltip": true, align: "right", label: "入库金额(不含税)", "min-width": "120", prop: "amountExcludingVat" })) : i("", true)], 64)) : i("", true), e(r).visible("applicantName") ? (a(), o(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : i("", true), e(r).visible("editorName") ? (a(), o(t, { key: "editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "editorName" })) : i("", true), e(r).visible("reviewerName") ? (a(), o(t, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : i("", true), e(r).visible("createTime") ? (a(), o(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" })) : i("", true), e(r).visible("reviewPassTime") ? (a(), o(t, { key: "reviewPassTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewPassTime", width: "140" })) : i("", true), s(t, { align: "center", fixed: "right", label: "操作", width: "70px" }, { default: u(({ row: l }) => [s($, { data: l, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[R, e(p).loading]]), s(e(q)), s(Y)]);
  };
} };
export {
  te as default
};
