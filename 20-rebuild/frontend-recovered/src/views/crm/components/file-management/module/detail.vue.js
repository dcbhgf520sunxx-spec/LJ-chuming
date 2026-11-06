import { ref as p } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as T } from "vue";
import { createBlock as b } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as V } from "vue";
import { isRef as I } from "vue";
import { ElTableColumn as B } from "element-plus";
import { u as N, lG as k, lq as y, G as q, L as v, lH as D } from "../../../../../shared/runtime.js";
const S = { __name: "detail", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: void 0 }, tenderType: { type: Number, default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(d, { emit: _ }) {
  const n = d, g = _, E = p([["createTime", ["parse-time", "{y}-{m}-{d}"]]]), u = p([]), { visible: c, handleClose: w } = N({ emit: g, props: n, showHook: R });
  function R() {
    h();
  }
  async function h() {
    var i, o, e, r, l;
    try {
      const t = await k({ crmProjectInformationWarehousingId: n.currentRow.crmProjectInformationWarehousingId, crmTenderRequirementTypeEnum: (i = n.currentRow) == null ? void 0 : i.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: ((o = n.currentRow) == null ? void 0 : o.crmTenderRequirementTypeEnum) === y.SETTLEMENT_METHOD.V ? (e = n.currentRow) == null ? void 0 : e.crmSpecialBubmissionStatusEnum : void 0, crmApplyTechnologyBiddingRecordId: ((r = n.currentRow) == null ? void 0 : r.crmTenderRequirementTypeEnum) === y.SETTLEMENT_METHOD.V ? (l = n.currentRow) == null ? void 0 : l.crmApplyTechnologyBiddingRecordId : void 0 });
      u.value = t, console.log(t);
    } catch (t) {
      console.log(t);
    }
  }
  return (i, o) => {
    const e = B, r = f("common-table"), l = f("common-drawer");
    return T(), b(l, { modelValue: m(c), "onUpdate:modelValue": o[0] || (o[0] = (t) => I(c) ? c.value = t : null), "before-close": m(w), "close-on-click-modal": false, size: "70%", title: "文档列表" }, { content: s(() => [a(r, { data: u.value, "data-format": E.value }, { default: s(() => [a(e, { type: "index", align: "center", label: "序号" }), a(e, { align: "center", label: "日期", prop: "createTime" }), a(e, { align: "center", label: "导入人", prop: "importUserName" }), a(e, { align: "center", label: "文件类型", prop: "fileTypeName" }), a(e, { align: "center", label: "附件", prop: "attachmentDTO.name", width: "300" }), m(q)(d.permission.export) ? (T(), b(e, { key: 0, align: "center", label: "操作", width: "150" }, { default: s(({ row: t }) => [a(v, { params: { id: t.attachmentDTO.id }, fn: m(D) }, null, 8, ["params", "fn"])]), _: 1 })) : V("", true)]), _: 1 }, 8, ["data", "data-format"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  S as default
};
