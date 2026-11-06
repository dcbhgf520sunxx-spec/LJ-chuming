import { ref as r } from "vue";
import { watch as L } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as O } from "vue";
import { createBlock as R } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as D } from "vue";
import { unref as u } from "vue";
import { ElMessageBox as x } from "element-plus";
import { ElMessage as C } from "element-plus";
import { ElFormItem as V } from "element-plus";
import { ElForm as B } from "element-plus";
import { j as k } from "../../../../../modules/win-bid-list-285b5b2e.js";
import { u as E, R as S, S as j } from "../../../../../shared/runtime.js";
const A = { __name: "upload-dialog", props: { modelValue: { type: Boolean, default: void 0 }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "uploadSuccess"], setup(_, { emit: v }) {
  const i = r(false), c = r(), t = r({ attachmentDTOList: [], id: void 0 }), l = _, m = v, { visible: f, handleClose: d } = E({ emit: m, props: l });
  L(() => f.value, (s) => {
    var e, a;
    s && (l.currentRow ? t.value.attachmentDTOList = (e = l.currentRow) == null ? void 0 : e.sealContractAttachmentList : t.value = {}, (a = c.value) == null || a.clearValidate());
  }, { immediate: true });
  const g = { attachmentDTOList: [{ required: true, message: "请上传附件", trigger: "change" }] };
  async function h() {
    c.value.validate(async (s) => {
      var e;
      if (s) try {
        i.value = true, await x.confirm("是否确认上传合同附件？", "提示", { closeOnClickModal: false, confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await k({ id: (e = l.currentRow) == null ? void 0 : e.id, attachmentDTOList: t.value.attachmentDTOList }), C.success("上传合同成功"), d(), m("uploadSuccess");
      } catch (a) {
        console.log(a, "上传合同失败");
      } finally {
        i.value = false;
      }
    });
  }
  return (s, e) => {
    const a = p("common-button"), w = V, b = B, y = p("common-dialog");
    return O(), R(y, { visible: u(f), "close-on-click-modal": false, "before-close": u(d), title: "合同上传列表" }, { titleRight: o(() => [n(a, { type: "primary", size: "default", onClick: h, loading: i.value }, { default: o(() => e[1] || (e[1] = [D("确认")])), _: 1, __: [1] }, 8, ["loading"])]), default: o(() => [n(b, { ref_key: "formRef", ref: c, model: t.value, "label-width": "130px", "label-position": "top", rules: g }, { default: o(() => [n(w, { label: "", prop: "attachmentDTOList" }, { default: o(() => [n(S, { showView: "", "show-download": "", files: t.value.attachmentDTOList, "onUpdate:files": e[0] || (e[0] = (T) => t.value.attachmentDTOList = T), "file-classify": u(j).RECORD_ATT.V }, null, 8, ["files", "file-classify"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} };
export {
  A as default
};
