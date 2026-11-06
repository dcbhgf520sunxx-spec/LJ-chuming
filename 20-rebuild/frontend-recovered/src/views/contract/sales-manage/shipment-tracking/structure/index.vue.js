import { ref as u } from "vue";
import { computed as x } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as a } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as r } from "vue";
import { createElementVNode as S } from "vue";
import { toDisplayString as U } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as j } from "element-plus";
import { d as B } from "../../../../../modules/shipment-tracking-bae05d4c.js";
import { Q as D } from "../../../../../modules/contract-9b18cc88.js";
import { t as T, x as H, o as E, P as V } from "../../../../../shared/runtime.js";
import q from "./module/header.vue.js";
const $ = { __name: "index", props: ["rowStyle", "rowClick"], emits: ["resetQuery"], setup(c, { emit: d }) {
  const { decimalPrecision: m } = T(), b = d, f = { add: false, edit: false, del: false, download: false }, p = u(), g = u(), v = x(() => [["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["unitPrice", ["to-thousand", m.value.contract]], ["totalPrice", ["to-thousand", m.value.contract]]]), { crud: s, columns: i, CRUD: y } = H({ title: "结构制品", sort: [], permission: { ...D }, crudApi: { get: B }, optShow: { ...f }, invisibleColumns: ["actualUserName", "supplierName", "cargoSerialNumber", "workshopNames"] }, p), { maxHeight: k } = E({ extraBox: [".common-container", ".structure-container"], minHeight: 300, paginate: true });
  return y.HOOK.beforeResetQuery = () => {
    b("resetQuery");
  }, (L, M) => {
    const o = Q, N = w("table-cell-tag"), _ = w("common-table"), P = j;
    return t(), C("div", null, [n(e(q), { ref_key: "headerRef", ref: g, class: "structure-container" }, null, 512), R((t(), a(_, { ref_key: "tableRef", ref: p, data: e(s).data, "data-format": v.value, "max-height": e(k), "row-style": c.rowStyle, onRowClick: c.rowClick }, { default: h(() => [n(o, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), e(i).visible("project") && !e(s).query.projectId ? (t(), a(o, { key: "project", align: "center", label: "项目", "min-width": "150", prop: "project", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("monomer.name") ? (t(), a(o, { key: "monomer.name", align: "center", label: "单体", "min-width": "130", prop: "monomer.name", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("area.name") ? (t(), a(o, { key: "area.name", align: "center", label: "区域", "min-width": "130", prop: "area.name", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("name") ? (t(), a(o, { key: "name", align: "center", label: "名称", "min-width": "130", prop: "name", "show-overflow-tooltip": "" }, { default: h(({ row: l }) => [n(N, { offset: 15, show: !!(l != null && l.boolExistReturn), color: "#e64242", name: "退货" }, null, 8, ["show"]), S("span", null, U(l.name), 1)]), _: 1 })) : r("", true), e(i).visible("serialNumber") ? (t(), a(o, { key: "serialNumber", align: "center", label: "编号", "min-width": "140", prop: "serialNumber", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("specification") ? (t(), a(o, { key: "specification", align: "center", label: "规格", "min-width": "140", prop: "specification", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("material") ? (t(), a(o, { key: "material", align: "center", label: "材质", "min-width": "110", prop: "material", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("totalQuantity") ? (t(), a(o, { key: "totalQuantity", align: "center", label: "数量", "min-width": "70", prop: "totalQuantity", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("weight") ? (t(), a(o, { key: "weight", align: "center", label: "总量(kg)", "min-width": "110", prop: "weight", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("unitPrice") ? (t(), a(o, { key: "unitPrice", align: "right", label: "单价", "min-width": "100", prop: "unitPrice" })) : r("", true), e(i).visible("totalPrice") ? (t(), a(o, { key: "totalPrice", align: "right", label: "金额", "min-width": "100", prop: "totalPrice" })) : r("", true), e(i).visible("createTime") ? (t(), a(o, { key: "createTime", align: "center", label: "发运日期", prop: "createTime", width: "100" })) : r("", true), e(i).visible("auditUserName") ? (t(), a(o, { key: "auditUserName", align: "center", label: "发运人", prop: "auditUserName", "show-overflow-tooltip": "", width: "90" })) : r("", true), e(i).visible("userName") ? (t(), a(o, { key: "userName", "show-overflow-tooltip": true, align: "center", label: "装车人", prop: "userName", width: "140" })) : r("", true), e(i).visible("actualUserName") ? (t(), a(o, { key: "actualUserName", align: "center", label: "过磅人", prop: "actualUserName", "show-overflow-tooltip": "", width: "90" })) : r("", true), e(i).visible("supplierName") ? (t(), a(o, { key: "supplierName", align: "center", label: "物流公司", "min-width": "120", prop: "supplierName", "show-overflow-tooltip": "" })) : r("", true), e(i).visible("cargoSerialNumber") ? (t(), a(o, { key: "cargoSerialNumber", prop: "cargoSerialNumber", "show-overflow-tooltip": "", label: "车次/船次", align: "center", width: "110" })) : r("", true), e(i).visible("licensePlate") ? (t(), a(o, { key: "licensePlate", prop: "licensePlate", "show-overflow-tooltip": "", label: "车牌/船牌", align: "center", width: "100" })) : r("", true), e(i).visible("workshopNames") ? (t(), a(o, { key: "workshopNames", align: "center", label: "生产部门", "min-width": "120", prop: "workshopNames", "show-overflow-tooltip": "" })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "row-style", "onRowClick"])), [[P, e(s).loading]]), n(e(V))]);
  };
} };
export {
  $ as default
};
