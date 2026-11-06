import { ref as p } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as P } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as y } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as U } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as O } from "../../../../../modules/application-f2aa112e.js";
import { uv as S, x as B, AG as V, o as $, aR as M, i as E, ux as H, an as F, P as K } from "../../../../../shared/runtime.js";
import q from "./module/header.vue.js";
import z from "./module/detail.vue.js";
import G from "./module/application.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../components/reject-match-info.vue.js";
import "../../../../../modules/vertical-label-c3028fe0.js";
import "./module/preview.vue.js";
import "./module/preview-confirm.vue.js";
const I = { class: "app-container" }, L = { key: 1 }, re = { __name: "index", setup(J) {
  const N = { add: false, edit: false, del: false, download: false }, u = p([]), c = p(false), f = p(), v = p(), g = p([...S]), { crud: m, columns: o } = B({ title: "退货办理", sort: ["id.desc"], invisibleColumns: ["applicantName", "reviewerName", "reviewTime", "editorName", "userUpdateTime", "licensePlate"], permission: { ...V }, optShow: { ...N }, crudApi: { ...O } }, f), { maxHeight: x } = $({ paginate: true });
  function C(b) {
    c.value = true, v.value = b.id;
  }
  return (b, n) => {
    const a = A, T = h("common-button"), R = h("common-table"), j = D;
    return t(), _("div", I, [s(q), P((t(), i(R, { ref_key: "tableRef", ref: f, data: e(m).data, "data-format": g.value, "max-height": e(x), "default-expand-all": false, "expand-row-keys": u.value, "row-key": "id" }, { default: d(() => [s(M, { data: e(m).data, "expand-row-keys": u.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (r) => u.value = r), "row-key": "id" }, { default: d(({ row: r }) => [y("p", null, [n[2] || (n[2] = k(" 关联项目：")), y("span", null, U(r.projectsFullName), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(a, { label: "序号", type: "index", align: "center", width: "60" }), e(o).visible("purchaseOrder.serialNumber") ? (t(), i(a, { key: "purchaseOrder.serialNumber", "show-overflow-tooltip": true, prop: "purchaseOrder.serialNumber", label: "采购合同编号", "min-width": "155" }, { default: d(({ row: r }) => {
      var w;
      return [e(E)((w = r.purchaseOrder) == null ? void 0 : w.id) ? (t(), i(e(H), { key: 0, "receipt-types": ["PURCHASE"], receipt: r.purchaseOrder }, null, 8, ["receipt"])) : (t(), _("span", L, "-"))];
    }), _: 1 })) : l("", true), e(o).visible("serialNumber") ? (t(), i(a, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", "min-width": "160", label: "入库单号", align: "left" })) : l("", true), e(o).visible("licensePlate") ? (t(), i(a, { key: "licensePlate", "show-overflow-tooltip": true, prop: "licensePlate", label: "车牌/船牌号", align: "left", width: "100" })) : l("", true), e(o).visible("basicClass") ? (t(), i(a, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", width: "120" })) : l("", true), e(o).visible("projects") ? (t(), i(a, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : l("", true), e(o).visible("supplier.name") ? (t(), i(a, { key: "supplier.name", "show-overflow-tooltip": true, prop: "supplier.name", label: "供应商", "min-width": "200" })) : l("", true), e(o).visible("applicantName") ? (t(), i(a, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "入库申请人", align: "center", "min-width": "100" })) : l("", true), e(o).visible("editorName") ? (t(), i(a, { key: "editorName", "show-overflow-tooltip": true, prop: "editorName", label: "入库编辑人", align: "center", "min-width": "100" })) : l("", true), e(o).visible("reviewerName") ? (t(), i(a, { key: "reviewerName", "show-overflow-tooltip": true, prop: "reviewerName", label: "入库审核人", align: "center", "min-width": "100" })) : l("", true), e(o).visible("createTime") ? (t(), i(a, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "入库办理时间", align: "center", width: "140" })) : l("", true), e(o).visible("userUpdateTime") ? (t(), i(a, { key: "userUpdateTime", "show-overflow-tooltip": true, prop: "userUpdateTime", label: "入库编辑时间", align: "center", width: "140" })) : l("", true), e(o).visible("reviewTime") ? (t(), i(a, { key: "reviewTime", "show-overflow-tooltip": true, prop: "reviewTime", label: "入库审核时间", align: "center", width: "140" })) : l("", true), s(a, { label: "操作", width: "170", align: "center", fixed: "right" }, { default: d(({ row: r }) => [s(F, { data: r, "show-detail": "", "show-edit": false, "show-del": false }, null, 8, ["data"]), s(T, { type: "primary", size: "default", onClick: (w) => C(r) }, { default: d(() => n[3] || (n[3] = [k("退货办理")])), _: 2, __: [3] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[j, e(m).loading]]), s(e(K)), s(z), s(G, { visible: c.value, "onUpdate:visible": n[1] || (n[1] = (r) => c.value = r), "inbound-id": v.value, onSuccess: e(m).refresh }, null, 8, ["visible", "inbound-id", "onSuccess"])]);
  };
} };
export {
  re as default
};
