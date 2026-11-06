import { computed as C } from "vue";
import { ref as S } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as n } from "vue";
import { withDirectives as R } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as l } from "vue";
import { createElementVNode as D } from "vue";
import { toDisplayString as j } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as T } from "element-plus";
import { t as q, x as H, o as Q, P as E } from "../../../../../shared/runtime.js";
import { f as V } from "../../../../../modules/shipment-tracking-bae05d4c.js";
import { Q as A } from "../../../../../modules/contract-9b18cc88.js";
import L from "./module/header.vue.js";
const z = { __name: "index", props: ["rowStyle", "rowClick"], emits: ["resetQuery"], setup(m, { emit: b }) {
  const { decimalPrecision: p } = q(), f = { add: false, edit: false, del: false, download: false }, g = C(() => [["project", "parse-project"], ["actualTime", ["parse-time", "{y}-{m}-{d}"]], ["unitPrice", ["to-thousand", p.value.contract]], ["totalPrice", ["to-thousand", p.value.contract]]]), v = b, u = S(), { crud: s, columns: i, CRUD: y } = H({ title: "结构制品", sort: [], permission: { ...A }, crudApi: { get: V }, optShow: { ...f }, invisibleColumns: ["actualUserName", "supplierName", "cargoSerialNumber", "workshopNames"] }, u), { maxHeight: k } = Q({ extraBox: [".common-container", ".structure-container"], minHeight: 300, paginate: true });
  return y.HOOK.beforeResetQuery = () => {
    v("resetQuery");
  }, (N, M) => {
    const o = B, w = d("table-cell-tag"), _ = d("common-table"), P = E, x = T;
    return t(), U("div", null, [n(L), R((t(), a(_, { ref_key: "tableRef", ref: u, data: e(s).data, "data-format": g.value, "max-height": e(k), "row-style": m.rowStyle, onRowClick: m.rowClick }, { default: c(() => [n(o, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), e(i).visible("project") && !e(s).query.projectId ? (t(), a(o, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", "min-width": "150" })) : l("", true), e(i).visible("monomer.name") ? (t(), a(o, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": "", label: "单体", align: "center", "min-width": "130" }, { default: c(({ row: r }) => {
      var h;
      return [n(w, { show: r.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), D("span", null, j((h = r.monomer) == null ? void 0 : h.name), 1)];
    }), _: 1 })) : l("", true), e(i).visible("area.name") ? (t(), a(o, { key: "area.name", prop: "area.name", "show-overflow-tooltip": "", label: "区域", align: "center", "min-width": "130" })) : l("", true), e(i).visible("name") ? (t(), a(o, { key: "name", align: "center", label: "名称", "min-width": "130", prop: "name", "show-overflow-tooltip": "" }, { default: c(() => {
      var r;
      return [n(w, { offset: 15, show: !!((r = N.row) != null && r.boolExistReturn), color: "#e64242", name: "退货" }, null, 8, ["show"])];
    }), _: 1 })) : l("", true), e(i).visible("serialNumber") ? (t(), a(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", "min-width": "120" })) : l("", true), e(i).visible("specification") ? (t(), a(o, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "140" })) : l("", true), e(i).visible("material") ? (t(), a(o, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "110" })) : l("", true), e(i).visible("quantity") ? (t(), a(o, { key: "quantity", prop: "quantity", label: "数量", align: "center", "min-width": "70", "show-overflow-tooltip": "" })) : l("", true), e(i).visible("weight") ? (t(), a(o, { key: "weight", prop: "weight", "show-overflow-tooltip": "", label: "总量(kg)", align: "center", "min-width": "110" })) : l("", true), e(i).visible("unitPrice") ? (t(), a(o, { key: "unitPrice", prop: "unitPrice", align: "right", "min-width": "100", label: "单价" })) : l("", true), e(i).visible("totalPrice") ? (t(), a(o, { key: "totalPrice", prop: "totalPrice", align: "right", "min-width": "100", label: "金额" })) : l("", true), e(i).visible("actualTime") ? (t(), a(o, { key: "actualTime", prop: "actualTime", align: "center", label: "发运日期", width: "100" })) : l("", true), e(i).visible("auditUserName") ? (t(), a(o, { key: "auditUserName", prop: "auditUserName", "show-overflow-tooltip": "", label: "发运人", align: "center", width: "90" })) : l("", true), e(i).visible("userName") ? (t(), a(o, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "装车人", align: "center", width: "140" })) : l("", true), e(i).visible("actualUserName") ? (t(), a(o, { key: "actualUserName", prop: "actualUserName", "show-overflow-tooltip": "", label: "过磅人", align: "center", width: "90" })) : l("", true), e(i).visible("supplierName") ? (t(), a(o, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": "", label: "物流公司", align: "center", "min-width": "120" })) : l("", true), e(i).visible("cargoSerialNumber") ? (t(), a(o, { key: "cargoSerialNumber", prop: "cargoSerialNumber", "show-overflow-tooltip": "", label: "车次/船次", align: "center", width: "110" })) : l("", true), e(i).visible("licensePlate") ? (t(), a(o, { key: "licensePlate", prop: "licensePlate", "show-overflow-tooltip": "", label: "车牌/船牌", align: "center", width: "100" })) : l("", true), e(i).visible("workshopNames") ? (t(), a(o, { key: "workshopNames", prop: "workshopNames", "show-overflow-tooltip": "", label: "生产部门", align: "center", "min-width": "120" })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "row-style", "onRowClick"])), [[x, e(s).loading]]), n(P)]);
  };
} };
export {
  z as default
};
